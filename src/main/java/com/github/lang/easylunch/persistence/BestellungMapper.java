package com.github.lang.easylunch.persistence;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.lang.easylunch.domain.AuswertungItem;
import com.github.lang.easylunch.domain.Bestellung;

public interface BestellungMapper {

    void save(Bestellung bestellung);

    void update(Bestellung bestellung);

    void deleteById(Long id);

    Bestellung getById(Long id);

    List<Bestellung> findAll();

    List<Bestellung> findAllByBenutzerAfterDate(
            @Param("benutzerId") Long benutzerId,
            @Param("date") Date date);

    List<AuswertungItem> auswertung(
            @Param("begin") Date begin,
            @Param("end") Date end);

}
