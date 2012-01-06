package com.github.lang.easylunch.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.lang.easylunch.domain.Bestellung;
import com.github.lang.easylunch.persistence.BestellungMapper;

@Controller
public class BestellungFormController {

//    @Autowired
//    private BenutzerMapper benutzerMapper;
//
//    @RequestMapping(value = "/benutzer/create", method = RequestMethod.GET)
//    public String createGet(Model model) {
//        model.addAttribute("benutzer", new Benutzer());
//        return "benutzer/create";
//    }
//
//    @RequestMapping(value = "/benutzer/create", method = RequestMethod.POST, params = "cancel")
//    public String createCancel(Model model) {
//        return "redirect:/wui/benutzer";
//    }
//
//    @RequestMapping(value = "/benutzer/create", method = RequestMethod.POST, params = "submit")
//    public String createSubmit(Model model,
//                               @ModelAttribute @Valid Benutzer benutzer,
//                               BindingResult result) {
//        if(result.hasErrors()) {
//            return "benutzer/create";
//        }
//        benutzerMapper.save(benutzer);
//        System.out.println("id: " + benutzer.getId());
//        return "redirect:/wui/benutzer";
//    }
//
//    @RequestMapping(value = "/benutzer/edit", method = RequestMethod.GET)
//    public String editGet(Model model,
//                          @RequestParam("id") Long id) {
//        Benutzer benutzer = benutzerMapper.getById(id);
//        model.addAttribute("benutzer", benutzer);
//        return "benutzer/edit";
//    }
//
//    @RequestMapping(value = "/benutzer/edit", method = RequestMethod.POST, params = "cancel")
//    public String editCancel(Model model) {
//        return "redirect:/wui/benutzer";
//    }
//
//    @RequestMapping(value = "/benutzer/edit", method = RequestMethod.POST, params = "submit")
//    public String editSubmit(Model model,
//                             @ModelAttribute @Valid Benutzer benutzer,
//                             BindingResult result) {
//        if(result.hasErrors()) {
//            return "benutzer/edit";
//        }
//        benutzerMapper.update(benutzer);
//        return "redirect:/wui/benutzer";
//    }
//
//    @RequestMapping(value = "/benutzer/delete", method = RequestMethod.GET)
//    public String deleteGet(Model model, @RequestParam("id") Long id) {
//        Benutzer benutzer = benutzerMapper.getById(id);
//        model.addAttribute("benutzer", benutzer);
//        return "benutzer/delete";
//    }
//
//    @RequestMapping(value = "/benutzer/delete", method = RequestMethod.POST, params = "cancel")
//    public String deleteCancel(Model model) {
//        return "redirect:/wui/benutzer";
//    }
//
//    @RequestMapping(value = "/benutzer/delete", method = RequestMethod.POST, params = "submit")
//    public String deleteSubmit(Model model, @RequestParam("id") Long id) {
//        benutzerMapper.deleteById(id);
//        return "redirect:/wui/benutzer";
//    }

}
