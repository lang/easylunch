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

import com.github.lang.easylunch.domain.Benutzer;
import com.github.lang.easylunch.persistence.BenutzerMapper;
import com.github.lang.easylunch.service.BenutzerService;

@Controller
public class BenutzerFormController {

    @Autowired
    private BenutzerMapper benutzerMapper;

    @Autowired
    private BenutzerService benutzerService;

    @RequestMapping(value = "/benutzer/create", method = RequestMethod.GET)
    public String createGet(Model model) {
        model.addAttribute("benutzer", new Benutzer());
        return "benutzer/create";
    }

    @RequestMapping(value = "/benutzer/create", method = RequestMethod.POST, params = "cancel")
    public String createCancel(Model model) {
        return "redirect:/wui/benutzer";
    }

    @RequestMapping(value = "/benutzer/create", method = RequestMethod.POST, params = "submit")
    public String createSubmit(Model model,
                               @ModelAttribute @Valid Benutzer benutzer,
                               BindingResult result) {
        if(result.hasErrors()) {
            return "benutzer/create";
        }
        benutzerMapper.save(benutzer);
        System.out.println("id: " + benutzer.getId());
        return "redirect:/wui/benutzer";
    }

    @RequestMapping(value = "/benutzer/edit", method = RequestMethod.GET)
    public String editGet(Model model,
                          @RequestParam("id") Long id) {
        Benutzer benutzer = benutzerMapper.findById(id);
        model.addAttribute("benutzer", benutzer);
        return "benutzer/edit";
    }

    @RequestMapping(value = "/benutzer/edit", method = RequestMethod.POST, params = "cancel")
    public String editCancel(Model model) {
        return "redirect:/wui/benutzer";
    }

    @RequestMapping(value = "/benutzer/edit", method = RequestMethod.POST, params = "submit")
    public String editSubmit(Model model,
                             @ModelAttribute @Valid Benutzer benutzer,
                             BindingResult result) {
        if(result.hasErrors()) {
            return "benutzer/edit";
        }
        // copy form attributes into benutzer from db
        Benutzer pb = benutzerMapper.findById(benutzer.getId());
        pb.setBenutzername(benutzer.getBenutzername());
        pb.setPersonalNummer(benutzer.getPersonalNummer());
        pb.setTitel(benutzer.getTitel());
        pb.setVorname(benutzer.getVorname());
        pb.setNachname(benutzer.getNachname());
        pb.setIstGast(benutzer.getIstGast());
        pb.setIstMitarbeiter(benutzer.getIstMitarbeiter());
        pb.setIstVerwaltung(benutzer.getIstVerwaltung());
        pb.setAktiv(benutzer.getAktiv());
        benutzerMapper.update(pb);
        return "redirect:/wui/benutzer";
    }

    @RequestMapping(value = "/benutzer/delete", method = RequestMethod.GET)
    public String deleteGet(Model model, @RequestParam("id") Long id) {
        Benutzer benutzer = benutzerMapper.findById(id);
        model.addAttribute("benutzer", benutzer);
        return "benutzer/delete";
    }

    @RequestMapping(value = "/benutzer/delete", method = RequestMethod.POST, params = "cancel")
    public String deleteCancel(Model model) {
        return "redirect:/wui/benutzer";
    }

    @RequestMapping(value = "/benutzer/delete", method = RequestMethod.POST, params = "submit")
    public String deleteSubmit(Model model, @RequestParam("id") Long id) {
        benutzerMapper.deleteById(id);
        return "redirect:/wui/benutzer";
    }

    @RequestMapping(value = "/benutzer/update_password", method = RequestMethod.GET)
    public String updatePasswordGet(Model model,
                                    @RequestParam("id") Long id) {
        Benutzer benutzer = benutzerMapper.findById(id);
        model.addAttribute("benutzer", benutzer);
        return "benutzer/update_password";
    }

    @RequestMapping(value = "/benutzer/update_password", method = RequestMethod.POST, params = "cancel")
    public String updatePasswordCancel(Model model) {
        return "redirect:/wui/benutzer";
    }

    @RequestMapping(value = "/benutzer/update_password", method = RequestMethod.POST, params = "submit")
    public String updatePasswordSubmit(Model model,
                                       @ModelAttribute Benutzer benutzer,
                                       BindingResult result) {
        if(!benutzer.getCleartextPassword().equals(benutzer.getCleartextPasswordRepeat())) {
            result.rejectValue(
                "cleartextPasswordRepeat", "benutzer.password_mismatch");
        }
        if(result.hasErrors()) {
            // load the user object with all attributes
            Benutzer pb = benutzerMapper.findById(benutzer.getId());
            benutzer.setBenutzername(pb.getBenutzername());
            return "benutzer/update_password";
        }
        benutzerService.updatePassword(
            benutzer.getId(), benutzer.getCleartextPassword());
        return "redirect:/wui/benutzer";
    }

}
