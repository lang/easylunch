package com.github.lang.easylunch.domain;

import java.util.List;

public class AuswertungItem {

    private Speise speise;
    private List<Bestellung> bestellungen;
    private Integer lagerdiff;

    public void setSpeise(Speise speise) {
        this.speise = speise;
    }

    public Speise getSpeise() {
        return speise;
    }
    
    public void setBestellungen(List<Bestellung> bestellungen) {
        this.bestellungen = bestellungen;
    }
    
    public List<Bestellung> getBestellungen() {
        return bestellungen;
    }
    
    public void setLagerdiff(Integer lagerdiff) {
        this.lagerdiff = lagerdiff;
    }

    public Integer getLagerdiff() {
        return lagerdiff;
    }

}
