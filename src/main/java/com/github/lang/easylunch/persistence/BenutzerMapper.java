package com.github.lang.easylunch.persistence;

import java.util.List;

import com.github.lang.easylunch.domain.Benutzer;

public interface BenutzerMapper {

    void save(Benutzer benutzer);

    void update(Benutzer benutzer);

    Benutzer getById(Long id);

    List<Benutzer> findAll();

}
