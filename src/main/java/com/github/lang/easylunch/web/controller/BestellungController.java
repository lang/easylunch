package com.github.lang.easylunch.web.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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

@Controller
public class BestellungController {

    private static final String SESSKEY = "vormerkListe";

    @Autowired
    private BestellungMapper bestellungMapper;

    @Autowired
    private SpeiseMapper speiseMapper;

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
        model.addAttribute("vorgemerkteSpeisen", speisen);
        model.addAttribute("vorgemerkteSumme", summe);
        return "bestellung/bestaetigen";
    }

}
