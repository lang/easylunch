package com.github.lang.easylunch.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Bestellung {

    private Long id;
    private Date konsumationszeitpunkt;
    private Date ausgabezeitpunkt;
    private BigDecimal ausgabepreis;
    private boolean storniert;
    private boolean bestaetigt;
    private Long benutzerId;
    private Long speiseId;
    // for UI
    private Speise speise;
    
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
    
    public void setAusgabepreis(BigDecimal ausgabepreis) {
        this.ausgabepreis = ausgabepreis;
    }

    public BigDecimal getAusgabepreis() {
        return ausgabepreis;
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
    	this.benutzerId = value;
    }
    
    public Long getBenutzerId() {
    	return this.benutzerId;
    }
    
    public void setSpeiseId(Long value) {
    	this.speiseId = value;
    }
    
    public Long getSpeiseId() {
    	return this.speiseId;
    }

    public void setSpeise(Speise speise) {
        this.speise = speise;
    }

    public Speise getSpeise() {
        return speise;
    }

}
