package com.github.lang.easylunch.persistence;

import java.util.List;

import com.github.lang.easylunch.domain.Bestellung;
import com.github.lang.easylunch.domain.Speise;

public interface BestellungenMapper {
/*
    void save(Bestellung bestellung);

    void update(Bestellung bestellung);

    void deleteById(Long id);

    Bestellung getById(Long id);
*/
    List<Bestellung> findAllOrders();
    
    List<Speise> findAllMeals();

}
