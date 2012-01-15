package com.github.lang.easylunch.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.lang.easylunch.domain.Bild;
import com.github.lang.easylunch.domain.Speise;
import com.github.lang.easylunch.persistence.BildMapper;
import com.github.lang.easylunch.persistence.SpeiseMapper;

@Controller
public class SpeiseController {

    @Autowired
    private BildMapper bildMapper;

    @Autowired
    private SpeiseMapper speiseMapper;

    @RequestMapping(value = "/speise", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("speisen", speiseMapper.findAll());
        return "speise/list";
    }

    @RequestMapping(value = "/speise/upload_bild", method = RequestMethod.GET)
    public String uploadBildGet(Model model, @RequestParam("id") Long id) {
        Speise speise = speiseMapper.findById(id);
        model.addAttribute("speise", speise);
        return "speise/upload_bild";
    }

    @RequestMapping(value = "/speise/upload_bild", method = RequestMethod.POST)
    public String uploadBildSubmit(@RequestParam("id") Long id,
                                   @RequestParam("file") Part file) throws IOException {
        Speise speise = speiseMapper.findById(id);
        Bild bild = new Bild();
        bild.setContentType(file.getContentType());
        bild.setData(IOUtils.toByteArray(file.getInputStream()));
        bild.setFilename(file.getName());
        bildMapper.save(bild);
        speise.setBildId(bild.getId());
        speiseMapper.update(speise);
        return "redirect:/wui/speise";
    }

    @RequestMapping(value = "/speise/bild", method = RequestMethod.GET)
    public void speiseBild(Model model,
                           @RequestParam("id") Long id,
                           HttpServletResponse response) throws IOException {
        Speise speise = speiseMapper.findById(id);
        Bild bild = bildMapper.findById(speise.getBildId());
        response.setContentType(bild.getContentType());
        response.getOutputStream().write(bild.getData());
        response.getOutputStream().flush();
    }

}
