package com.github.lang.easylunch.persistence;

import com.github.lang.easylunch.domain.Benutzer;

public interface BenutzerMapper {

    void save(Benutzer benutzer);

    Benutzer getById(Long id);

}
