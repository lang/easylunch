package com.github.lang.easylunch.web.controller;

import java.util.Calendar;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.lang.easylunch.domain.Speise;
import com.github.lang.easylunch.persistence.SpeiseMapper;

@Controller
public class SpeiseFormController {

    @Autowired
    private SpeiseMapper speiseMapper;

    @ModelAttribute("artOptions")
    public List<String> artOptions() {
        return Speise.ART_OPTIONS;
    }

    @RequestMapping(value = "/speise/create", method = RequestMethod.GET)
    public String createGet(Model model) {
        Speise speise = new Speise();
        Calendar cal = Calendar.getInstance();
        speise.setImSortimentAb(cal.getTime());
        cal.add(Calendar.YEAR, 100);
        speise.setImSortimentBis(cal.getTime());
        model.addAttribute("speise", speise);
        return "speise/create";
    }

    @RequestMapping(value = "/speise/create", method = RequestMethod.POST, params = "cancel")
    public String createCancel(Model model) {
        return "redirect:/wui/speise";
    }

    @RequestMapping(value = "/speise/create", method = RequestMethod.POST, params = "submit")
    public String createSubmit(Model model,
                               @ModelAttribute @Valid Speise speise,
                               BindingResult result) {
        if(result.hasErrors()) {
            return "speise/create";
        }
        speiseMapper.save(speise);
        return "redirect:/wui/speise";
    }

}
