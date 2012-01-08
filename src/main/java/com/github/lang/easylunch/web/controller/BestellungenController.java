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
import java.util.Hashtable;
import java.util.List;

import com.github.lang.easylunch.service.BestellungsauswertungService;

import java.text.*;

@Controller
public class BestellungenController {
	
    @Autowired
	private BestellungsauswertungService auswertungService;

	private String dateStringFormat = "EEE, d MMM yyyy";
	private Hashtable ordersAggregated = null; 

    @Autowired
    private BestellungenMapper bestellungenMapper;

    @RequestMapping(value = "/bestellungen", method = RequestMethod.GET)
    public String auswerten(Model model) {
    	Date dateObj = new Date();
    	SimpleDateFormat dateFormat = new SimpleDateFormat(dateStringFormat);
    	boolean compliable = false;
    	
        model.addAttribute("bestellungen", bestellungenMapper.findAllOrders());
        model.addAttribute("speisen", bestellungenMapper.findAllMeals());
        model.addAttribute("date", dateFormat.format(dateObj));
        
        // check if applying is possible
        ordersAggregated = aggregateData(bestellungenMapper.findAllOrders());
        
        for (int x = 0; x < ordersAggregated.size(); x++) {
        	if (!isOrderCompliable()) {
        		compliable = false;
        	}
        }
 		model.addAttribute("compliable", compliable);
        
        return "bestellungen/auswerten";
    }
    
    @RequestMapping(value = "/bestellungen/applyToStock", method = RequestMethod.POST)
    public String applyToStock(Model model) {
    	Date dateObj = new Date();
    	SimpleDateFormat dateFormat = new SimpleDateFormat(dateStringFormat);
    	
        model.addAttribute("bestellungen", bestellungenMapper.findAllOrders());
        model.addAttribute("speisen", bestellungenMapper.findAllMeals());
        model.addAttribute("date", dateFormat.format(dateObj));
        
    	return "bestellungen/applyToStock";
    }
    
    @RequestMapping(value = "/bestellungen/printPreview", method = RequestMethod.GET)
    public String printPreview(Model model) {
    	Date dateObj = new Date();
    	SimpleDateFormat dateFormat = new SimpleDateFormat(dateStringFormat);
    	
        model.addAttribute("bestellungen", bestellungenMapper.findAllOrders());
        model.addAttribute("speisen", bestellungenMapper.findAllMeals());
        model.addAttribute("date", dateFormat.format(dateObj));
        
        return "bestellungen/printPreview";
    }
    
    private boolean isOrderCompliable() {
    	return false;
    }
    
    private Hashtable aggregateData(List<Bestellung> orderList) {
    	
    	return new Hashtable();
    }
}