package com.github.lang.easylunch.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.lang.easylunch.domain.Bestellung;
import com.github.lang.easylunch.domain.Speise;
import com.github.lang.easylunch.persistence.BestellungenMapper;

import java.util.Date;
import java.text.*;

@Controller
public class BestellungenController {

    @Autowired
    private BestellungenMapper bestellungenMapper;

    @RequestMapping(value = "/bestellungen", method = RequestMethod.GET)
    public String auswerten(Model model) {
    	Date dateObj = new Date();
    	SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy");
    	
        model.addAttribute("bestellungen", bestellungenMapper.findAllOrders());
        model.addAttribute("speisen", bestellungenMapper.findAllMeals());
        model.addAttribute("date", dateFormat.format(dateObj));
        
        return "bestellungen/auswerten";
    }
    
    @RequestMapping(value = "/bestellungen/applyToStock", method = RequestMethod.POST)
    public String applyToStock(Model model) {
    	Date dateObj = new Date();
    	SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy");
    	
        model.addAttribute("bestellungen", bestellungenMapper.findAllOrders());
        model.addAttribute("speisen", bestellungenMapper.findAllMeals());
        model.addAttribute("date", dateFormat.format(dateObj));
        
    	return "bestellungen/applyToStock";
    }
    
    @RequestMapping(value = "/bestellungen/printPreview", method = RequestMethod.GET)
    public String printPreview(Model model) {
    	Date dateObj = new Date();
    	SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy");
    	
        model.addAttribute("bestellungen", bestellungenMapper.findAllOrders());
        model.addAttribute("speisen", bestellungenMapper.findAllMeals());
        model.addAttribute("date", dateFormat.format(dateObj));
        
        return "bestellungen/printPreview";
    }    
}
