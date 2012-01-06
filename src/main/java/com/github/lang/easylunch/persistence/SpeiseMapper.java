package com.github.lang.easylunch.persistence;

import java.util.List;

import com.github.lang.easylunch.domain.Speise;

public interface SpeiseMapper {

    void save(Speise speise);

    List<Speise> findAll();

}
