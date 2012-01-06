package com.github.lang.easylunch.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.lang.easylunch.domain.Speise;
import com.github.lang.easylunch.persistence.SpeiseMapper;

@Controller
public class SpeiseController {

    @Autowired
    private SpeiseMapper speiseMapper;

    @RequestMapping(value = "/speise", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("speisen", speiseMapper.findAll());
        return "speise/list";
    }

}
