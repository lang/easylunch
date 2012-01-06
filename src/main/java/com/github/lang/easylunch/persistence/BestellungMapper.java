package com.github.lang.easylunch.persistence;

import java.util.List;

import com.github.lang.easylunch.domain.Bestellung;

public interface BestellungMapper {

    void save(Bestellung bestellung);

    void update(Bestellung bestellung);

    void deleteById(Long id);

    Bestellung getById(Long id);

    List<Bestellung> findAll();

}
