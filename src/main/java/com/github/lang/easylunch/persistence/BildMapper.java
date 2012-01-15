package com.github.lang.easylunch.persistence;

import com.github.lang.easylunch.domain.Bild;

public interface BildMapper {

    void save(Bild bild);

    Bild findById(Long id);

}
