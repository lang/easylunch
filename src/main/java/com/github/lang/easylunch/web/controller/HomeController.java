package com.github.lang.easylunch.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.lang.easylunch.domain.Benutzer;
import com.github.lang.easylunch.service.BenutzerService;

@Controller
public class HomeController {

    @Autowired
    private BenutzerService benutzerService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        return "login";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Model model) {
        Benutzer benutzer = benutzerService.currentBenutzer();
        if(benutzer.getIstGast()) {
            return "redirect:/wui/bestellen";
        }
        return "redirect:/wui/speise";
    }

}
