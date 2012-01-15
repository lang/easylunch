package com.github.lang.easylunch.web.controller;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class,
            new CustomDateEditor(new SimpleDateFormat("dd.MM.yyyy"), true));
        binder.registerCustomEditor(BigDecimal.class,
            new CustomNumberEditor(BigDecimal.class, new DecimalFormat("0.#"), true));
    }

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

    @RequestMapping(value = "/speise/edit", method = RequestMethod.GET)
    public String editGet(Model model,
                          @RequestParam("id") Long id) {
        Speise speise = speiseMapper.findById(id);
        model.addAttribute("speise", speise);
        return "speise/edit";
    }

    @RequestMapping(value = "/speise/edit", method = RequestMethod.POST, params = "cancel")
    public String editCancel(Model model) {
        return "redirect:/wui/speise";
    }

    @RequestMapping(value = "/speise/edit", method = RequestMethod.POST, params = "submit")
    public String editSubmit(Model model,
                             @ModelAttribute @Valid Speise speise,
                             BindingResult result) {
        if(result.hasErrors()) {
            return "speise/edit";
        }
        Speise pSpeise = speiseMapper.findById(speise.getId());
        copyFormProperties(speise, pSpeise);
        speiseMapper.update(pSpeise);
        return "redirect:/wui/speise";
    }

    @RequestMapping(value = "/speise/delete", method = RequestMethod.GET)
    public String deleteGet(Model model, @RequestParam("id") Long id) {
        Speise speise = speiseMapper.findById(id);
        model.addAttribute("speise", speise);
        return "speise/delete";
    }

    @RequestMapping(value = "/speise/delete", method = RequestMethod.POST, params = "cancel")
    public String deleteCancel(Model model) {
        return "redirect:/wui/speise";
    }

    @RequestMapping(value = "/speise/delete", method = RequestMethod.POST, params = "submit")
    public String deleteSubmit(Model model, @RequestParam("id") Long id) {
        speiseMapper.deleteById(id);
        return "redirect:/wui/speise";
    }

    private void copyFormProperties(Speise src, Speise dst) {
        dst.setName(src.getName());
        dst.setBeschreibung(src.getBeschreibung());
        dst.setArt(src.getArt());
        dst.setImSortimentAb(src.getImSortimentAb());
        dst.setImSortimentBis(src.getImSortimentBis());
        dst.setPreis(src.getPreis());
        dst.setLagerstand(src.getLagerstand());
    }

}
