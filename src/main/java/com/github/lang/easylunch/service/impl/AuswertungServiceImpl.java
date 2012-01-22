package com.github.lang.easylunch.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.lang.easylunch.domain.AuswertungItem;
import com.github.lang.easylunch.persistence.BestellungMapper;
import com.github.lang.easylunch.service.ApplicationTimeService;
import com.github.lang.easylunch.service.AuswertungService;

@Service("auswertungService")
public class AuswertungServiceImpl implements AuswertungService {

    @Autowired
    private ApplicationTimeService applicationTimeService;

    @Autowired
    private BestellungMapper bestellungMapper;

    public List<AuswertungItem> auswertung() {
        Calendar cal = applicationTimeService.applicationTime();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        Date begin = cal.getTime();
        cal.add(Calendar.DAY_OF_MONTH, 1);
        Date end = cal.getTime();
        List<AuswertungItem> items = bestellungMapper.auswertung(begin, end);
        for(AuswertungItem item : items) {
            item.setLagerdiff(
                item.getSpeise().getLagerstand() -
                    item.getBestellungen().size());
        }
        return items;
    }

}
