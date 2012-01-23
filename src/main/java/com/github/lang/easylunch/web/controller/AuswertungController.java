package com.github.lang.easylunch.web.controller;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.lang.easylunch.domain.Bestellung;
import com.github.lang.easylunch.persistence.BestellungMapper;
import com.github.lang.easylunch.service.AuswertungService;

@Controller
public class AuswertungController {

    @Autowired
    private BestellungMapper bestellungMapper;

    @Autowired
    private AuswertungService auswertungService;

    @RequestMapping(value = "auswertung", method = RequestMethod.GET)
    public String auswertungGet(Model model) {
        model.addAttribute("auswertungItems", auswertungService.auswertung());
        return "auswertung/list";
    }

    @RequestMapping(value = "auswertung/print", method = RequestMethod.GET)
    public String auswertungPrint(Model model) {
        auswertungGet(model);
        return "auswertung/list_print";
    }

    @RequestMapping(value = "auswertung/bestellung/bestaetigen", method = RequestMethod.POST)
    public String auswertungBestellungBestaetigen(@RequestParam("id") Long id) {
        Bestellung bestellung = bestellungMapper.findById(id);
        bestellung.setBestaetigt(true);
        bestellungMapper.update(bestellung);
        return "redirect:/wui/auswertung";
    }

    @RequestMapping(value = "auswertung/bestellung/stornieren", method = RequestMethod.POST)
    public String auswertungBestellungStornieren(@RequestParam("id") Long id) {
        Bestellung bestellung = bestellungMapper.findById(id);
        bestellung.setStorniert(true);
        bestellungMapper.update(bestellung);
        return "redirect:/wui/auswertung";
    }

}
