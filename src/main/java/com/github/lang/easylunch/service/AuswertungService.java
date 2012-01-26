package com.github.lang.easylunch.service;

import java.util.List;

import com.github.lang.easylunch.domain.Bestellung;
import com.github.lang.easylunch.domain.AuswertungItem;

public interface AuswertungService {

    List<AuswertungItem> auswertung();

    void bestaetigen(Bestellung bestellung);

}
