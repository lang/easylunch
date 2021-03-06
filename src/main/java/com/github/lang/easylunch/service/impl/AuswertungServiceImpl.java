package com.github.lang.easylunch.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.lang.easylunch.domain.AuswertungItem;
import com.github.lang.easylunch.domain.Bestellung;
import com.github.lang.easylunch.domain.Speise;
import com.github.lang.easylunch.persistence.BestellungMapper;
import com.github.lang.easylunch.persistence.SpeiseMapper;
import com.github.lang.easylunch.service.ApplicationTimeService;
import com.github.lang.easylunch.service.AuswertungService;

@Service("auswertungService")
public class AuswertungServiceImpl implements AuswertungService {

    @Autowired
    private ApplicationTimeService applicationTimeService;

    @Autowired
    private BestellungMapper bestellungMapper;

    @Autowired
    private SpeiseMapper speiseMapper;

    public List<AuswertungItem> auswertung() {
        Calendar cal = applicationTimeService.applicationTime();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        Date begin = cal.getTime();
        cal.add(Calendar.DAY_OF_MONTH, 1);
        Date end = cal.getTime();
        List<AuswertungItem> items = bestellungMapper.auswertung(begin, end);
        for(AuswertungItem item : items) {
            int count = 0;
            for(Bestellung bestellung : item.getBestellungen()) {
                if(!bestellung.getStorniert() && !bestellung.getBestaetigt()) {
                    count++;
                }
            }
            item.setCount(count);
            item.setLagerdiff(item.getSpeise().getLagerstand() - count);
            item.setBestaetigenPossible(item.getSpeise().getLagerstand() > 0);
        }
        return items;
    }

    public void bestaetigen(Bestellung bestellung) {
        Speise speise = speiseMapper.findById(bestellung.getSpeiseId());
        if(speise.getLagerstand() > 0) {
            bestellung.setBestaetigt(true);
            speise.setLagerstand(speise.getLagerstand() - 1);
            bestellungMapper.update(bestellung);
            speiseMapper.update(speise);
        }
    }

}
