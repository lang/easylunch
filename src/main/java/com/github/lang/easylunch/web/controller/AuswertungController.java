package com.github.lang.easylunch.web.controller;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.lang.easylunch.service.AuswertungService;

@Controller
public class AuswertungController {

    @Autowired
    private AuswertungService auswertungService;

    @RequestMapping(value = "auswertung", method = RequestMethod.GET)
    public String auswertenGet(Model model) {
        model.addAttribute("auswertungItems", auswertungService.auswertung());
        return "auswertung/list";
    }

}
