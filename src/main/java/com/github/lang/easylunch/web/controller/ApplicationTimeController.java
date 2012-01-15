package com.github.lang.easylunch.web.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.lang.easylunch.service.ApplicationTimeService;

@Controller
public class ApplicationTimeController {

    @Autowired
    private ApplicationTimeService applicationTimeService;

    @RequestMapping(value = "/time", method = RequestMethod.GET)
    public String timeGet(Model model) {
        Date date = applicationTimeService.applicationTime().getTime();
        model.addAttribute("applicationTime", date);
        model.addAttribute("systemTime", new Date());
        return "time";
    }

    @RequestMapping(value = "/time", method = RequestMethod.POST, params = "submit")
    public String timePost(Model model,
                           @RequestParam("shiftHours") int shiftHours) {
        applicationTimeService.shiftByHours(shiftHours);
        return "redirect:/wui/time";
    }

}
