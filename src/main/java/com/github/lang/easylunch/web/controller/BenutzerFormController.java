package com.github.lang.easylunch.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.lang.easylunch.domain.Benutzer;

@Controller
public class BenutzerFormController {

    @RequestMapping(value = "/benutzer/create", method = RequestMethod.GET)
    public String createGet(Model model) {
        model.addAttribute("benutzer", new Benutzer());
        return "benutzer/create";
    }

    @RequestMapping(value = "/benutzer/create", method = RequestMethod.POST, params = "cancel")
    public String createCancel(Model model) {
        return "redirect:/benutzer";
    }

    @RequestMapping(value = "/benutzer/create", method = RequestMethod.POST, params = "submit")
    public String createSubmit(Model model,
                               @ModelAttribute Benutzer benutzer,
                               BindingResult result) {
        if(result.hasErrors()) {
            return "benutzer/create";
        }
        // TODO: persist benutzer
        return "redirect:/benutzer";
    }

}