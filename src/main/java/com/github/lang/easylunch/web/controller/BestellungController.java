package com.github.lang.easylunch.web.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.lang.easylunch.domain.Bestellung;
import com.github.lang.easylunch.domain.Speise;
import com.github.lang.easylunch.persistence.BestellungMapper;
import com.github.lang.easylunch.persistence.SpeiseMapper;
import com.github.lang.easylunch.service.ApplicationTimeService;
import com.github.lang.easylunch.service.BenutzerService;

@Controller
public class BestellungController {

    private static final String SESSKEY = "vormerkListe";

    private static final SimpleDateFormat DATE_FORMAT =
        new SimpleDateFormat("E, dd.MM.yyyy");

    @Autowired
    private BestellungMapper bestellungMapper;

    @Autowired
    private SpeiseMapper speiseMapper;

    @Autowired
    private ApplicationTimeService applicationTimeService;

    @Autowired
    private BenutzerService benutzerService;

    private String nextSpeiseArt(HttpSession session) {
        List<Long> vormerkListe = (List<Long>)session.getAttribute(SESSKEY);
        if(vormerkListe != null && !vormerkListe.isEmpty()) {
            Speise speise =
                speiseMapper.findById(vormerkListe.get(vormerkListe.size() - 1));
            if("Vorspeise".equals(speise.getArt())) {
                return "Hauptspeise";
            }
            else if("Hauptspeise".equals(speise.getArt())) {
                return "Nachspeise";
            }
        }
        return "Vorspeise";
    }

    @RequestMapping(value = "bestellung", method = RequestMethod.GET)
    public String bestellung(Model model,
                             HttpSession session,
                             @RequestParam(value = "art", required = false) String art) {
        if(art == null) {
            art = nextSpeiseArt(session);
        }
        Map<String, String> artOptions = new LinkedHashMap<String, String>();
        artOptions.put("Vorspeise", "Vorspeisen");
        artOptions.put("Hauptspeise", "Hauptspeisen");
        artOptions.put("Nachspeise", "Nachspeisen");
        model.addAttribute("artOptions", artOptions);
        model.addAttribute("art", art);
        model.addAttribute("speisen", speiseMapper.findAllByArt(art));
        return "bestellung/speisen";
    }

    @RequestMapping(value = "bestellung", method = RequestMethod.POST)
    public String bestellungPost(Model model,
                                 HttpSession session,
                                 @RequestParam("id") Long id) {
        List<Long> vormerkListe = (List<Long>)session.getAttribute(SESSKEY);
        if(vormerkListe == null) {
            vormerkListe = new ArrayList<Long>();
        }
        vormerkListe.add(id);
        session.setAttribute(SESSKEY, vormerkListe);
        return "redirect:/wui/bestellung/bestaetigen";
    }

    @RequestMapping(value = "bestellung/bestaetigen", method = RequestMethod.GET)
    public String bestaetigenGet(Model model, HttpSession session) {
        List<Speise> speisen = new ArrayList<Speise>();
        BigDecimal summe = BigDecimal.ZERO;
        List<Long> vormerkListe = (List<Long>)session.getAttribute(SESSKEY);
        if(vormerkListe != null) {
            for(Long id : vormerkListe) {
                Speise speise = speiseMapper.findById(id);
                speisen.add(speise);
                summe = summe.add(speise.getPreis());
            }
        }

        List<String> dateOptions = new ArrayList<String>(14);
        Calendar cal = applicationTimeService.applicationTime();
        if(cal.get(Calendar.HOUR_OF_DAY) >= 9) {
            cal.add(Calendar.DAY_OF_MONTH, 1);
        }
        for(int i = 0; i < 14; i++) {
            dateOptions.add(DATE_FORMAT.format(cal.getTime()));
            cal.add(Calendar.DAY_OF_MONTH, 1);
        }

        List<String> timeOptions = new ArrayList<String>(10);
        for(int i = 0; i < 5; i++) {
            timeOptions.add("" + (12 + i) + ":00");
            timeOptions.add("" + (12 + i) + ":30");
        }

        model.addAttribute("vorgemerkteSpeisen", speisen);
        model.addAttribute("vorgemerkteSumme", summe);
        model.addAttribute("dateOptions", dateOptions);
        model.addAttribute("timeOptions", timeOptions);
        model.addAttribute("bestellungen",
            setSpeisen(bestellungMapper.findAllByBenutzerAfterDate(
                benutzerService.currentBenutzer().getId(),
                applicationTimeService.applicationTime().getTime())));
        return "bestellung/bestaetigen";
    }

    @RequestMapping(value = "bestellung/bestaetigen", method = RequestMethod.POST)
    public String bestaetigenPost(Model model, HttpSession session,
                                  @RequestParam("date") String dateStr,
                                  @RequestParam("time") String timeStr) throws Exception {
        Calendar cal = Calendar.getInstance();
        cal.setTime(DATE_FORMAT.parse(dateStr));
        String[] timeParts = timeStr.split(":");
        cal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(timeParts[0]));
        cal.set(Calendar.MINUTE, Integer.parseInt(timeParts[1]));
        for(Long speiseId : (List<Long>)session.getAttribute(SESSKEY)) {
            Speise speise = speiseMapper.findById(speiseId);
            Bestellung bestellung = new Bestellung();
            bestellung.setKonsumationszeitpunkt(cal.getTime());
            bestellung.setAusgabepreis(speise.getPreis());
            bestellung.setBenutzerId(benutzerService.currentBenutzer().getId());
            bestellung.setSpeiseId(speiseId);
            bestellungMapper.save(bestellung);
        }
        session.setAttribute(SESSKEY, new ArrayList<Speise>());
        return "redirect:/wui/bestellung/bestaetigen";
    }

    @RequestMapping(value = "bestellung/bestaetigen/remove", method = RequestMethod.POST)
    public String bestaetigenRemovePost(Model model, HttpSession session,
                                        @RequestParam("id") Long id) {
        List<Long> vormerkListe = (List<Long>)session.getAttribute(SESSKEY);
        if(vormerkListe != null) {
            vormerkListe.remove(id);
        }
        return "redirect:/wui/bestellung/bestaetigen";
    }

    @RequestMapping(value = "bestellung/bestaetigen/stornieren", method = RequestMethod.POST)
    public String bestaetigenStornieren(@RequestParam("id") Long id) {
        Bestellung bestellung = bestellungMapper.findById(id);
        if(bestellung.getBenutzerId().equals(
              benutzerService.currentBenutzer().getId())) {
            bestellung.setStorniert(true);
            bestellungMapper.update(bestellung);
        }
        return "redirect:/wui/bestellung/bestaetigen";
    }

    @RequestMapping(value = "bestellung/historie", method = RequestMethod.GET)
    public String historie(Model model,
                           @RequestParam(value = "ym", required = false) String ym) {
        Long benutzerId = benutzerService.currentBenutzer().getId();
        Calendar cal = applicationTimeService.applicationTime();
        cal.clear();
        if(ym == null) {
            Calendar now = applicationTimeService.applicationTime();
            cal.set(Calendar.YEAR, now.get(Calendar.YEAR));
            cal.set(Calendar.MONTH, now.get(Calendar.MONTH));
        }
        else {
            String[] parts = ym.split("-");
            cal.set(Calendar.YEAR, Integer.parseInt(parts[0]));
            cal.set(Calendar.MONTH, Integer.parseInt(parts[1]) - 1);
        }
        Date begin = cal.getTime();
        cal.add(Calendar.MONTH, 1);
        Date end = cal.getTime();
        Calendar now = applicationTimeService.applicationTime();
        if(end.getTime() > now.getTimeInMillis()) {
            end = now.getTime();
        }
        List<Bestellung> bestellungen =
            bestellungMapper.findAllByBenutzerAndDateRange(benutzerId, begin, end);
        BigDecimal sum = BigDecimal.ZERO;
        for(Bestellung bestellung : bestellungen) {
            sum = sum.add(bestellung.getAusgabepreis());
        }
        List<Date> monthOptions = new ArrayList<Date>(12);
        cal = applicationTimeService.applicationTime();
        for(int i = 0; i < 12; i++) {
            monthOptions.add(cal.getTime());
            cal.add(Calendar.MONTH, -1);
        }
        model.addAttribute("month", begin);
        model.addAttribute("bestellungen", setSpeisen(bestellungen));
        model.addAttribute("sum", sum);
        model.addAttribute("monthOptions", monthOptions);
        return "bestellung/historie";
    }

    private List<Bestellung> setSpeisen(List<Bestellung> bestellungen) {
        for(Bestellung bestellung : bestellungen) {
            bestellung.setSpeise(speiseMapper.findById(bestellung.getSpeiseId()));
        }
        return bestellungen;
    }

}
