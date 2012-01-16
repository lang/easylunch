package com.github.lang.easylunch.persistence;

import java.util.List;

import com.github.lang.easylunch.domain.Speise;

public interface SpeiseMapper {

    void save(Speise speise);

    void update(Speise speise);

    void deleteById(Long id);

    Speise findById(Long id);

    List<Speise> findAll();

    List<Speise> findAllByArt(String art);

}
