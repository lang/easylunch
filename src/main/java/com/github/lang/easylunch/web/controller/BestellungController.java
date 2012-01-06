package com.github.lang.easylunch.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.lang.easylunch.domain.Bestellung;
import com.github.lang.easylunch.persistence.BestellungMapper;

@Controller
public class BestellungController {

    @Autowired
    private BestellungMapper bestellungenMapper;

    @RequestMapping(value = "/bestellen", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("bestellungen", bestellungenMapper.findAll());
        return "bestellen/list";
    }

}
