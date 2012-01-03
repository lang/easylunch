package com.github.lang.easylunch.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.lang.easylunch.domain.Benutzer;
import com.github.lang.easylunch.persistence.BenutzerMapper;

@Controller
public class BenutzerController {

    @Autowired
    private BenutzerMapper benutzerMapper;

    @RequestMapping(value = "/benutzer", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("benutzerList", benutzerMapper.findAll());
        return "benutzer/list";
    }

}
