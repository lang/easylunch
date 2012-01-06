package com.github.lang.easylunch.domain;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Speise {

    public static final List<String> ART_OPTIONS =
        Arrays.asList("Vorspeise", "Hauptspeise", "Nachspeise");

    private Long id;
    @Size(min = 1, max = 255)
    private String name;
    @Size(max = 2048)
    private String beschreibung;
    @Size(min = 1, max = 255)
    private String art;
    private Long bildId;
    @NotNull
    private Date imSortimentAb;
    @NotNull
    private Date imSortimentBis;
    @NotNull
    private BigDecimal preis;
    private int lagerstand;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }
    
    public String getBeschreibung() {
        return beschreibung;
    }
    
    public void setArt(String art) {
        this.art = art;
    }
    
    public String getArt() {
        return art;
    }
    
    public void setBildId(Long bildId) {
        this.bildId = bildId;
    }
    
    public Long getBildId() {
        return bildId;
    }
    
    public void setImSortimentAb(Date imSortimentAb) {
        this.imSortimentAb = imSortimentAb;
    }
    
    public Date getImSortimentAb() {
        return imSortimentAb;
    }
    
    public void setImSortimentBis(Date imSortimentBis) {
        this.imSortimentBis = imSortimentBis;
    }
    
    public Date getImSortimentBis() {
        return imSortimentBis;
    }
    
    public void setPreis(BigDecimal preis) {
        this.preis = preis;
    }
    
    public BigDecimal getPreis() {
        return preis;
    }
    
    public void setLagerstand(int lagerstand) {
        this.lagerstand = lagerstand;
    }
    
    public int getLagerstand() {
        return lagerstand;
    }

}
