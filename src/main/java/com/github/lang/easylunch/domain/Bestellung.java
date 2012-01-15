package com.github.lang.easylunch.domain;


import java.util.*;

public class Bestellung {

    private Long id;
    private Date konsumationszeitpunkt;
    private Date ausgabezeitpunkt;
    private double ausgabepreis;
    private boolean storniert;
    private boolean bestaetigt;
    private Long benutzer_id;
    private Long speise_id;
    
    public void setId(Long value) {
    	this.id = value;
    }
    
    public Long getId() {
    	return this.id;
    }
    
    public void setKonsumationszeitpunkt(Date value) {
    	this.konsumationszeitpunkt = value;
    }
    
    public Date getKonsumationszeitpunkt() {
    	return this.konsumationszeitpunkt;
    }
    
    public void setAusgabezeitpunkt(Date value) {
    	this.ausgabezeitpunkt = value;
    }
    
    public Date getAusgabezeitpunkt() {
    	return this.ausgabezeitpunkt;
    }
    
    public void setAusgabepreis(double value) {
    	this.ausgabepreis = value;
    }
    
    public double getAusgabepreis() {
    	return this.ausgabepreis;
    }
    
    public void setStorniert(boolean value) {
    	this.storniert = value;
    }
    
    public boolean getStorniert() {
    	return this.storniert;
    }
    
    public void setBestaetigt(boolean value) {
    	this.bestaetigt = value;
    }
    
    public boolean getBestaetigt() {
    	return this.bestaetigt;
    }
    
    public void setBenutzerId(Long value) {
    	this.benutzer_id = value;
    }
    
    public Long getBenutzerId() {
    	return this.benutzer_id;
    }
    
    public void setSpeiseId(Long value) {
    	this.speise_id = value;
    }
    
    public Long getSpeiseId() {
    	return this.speise_id;
    }

}
