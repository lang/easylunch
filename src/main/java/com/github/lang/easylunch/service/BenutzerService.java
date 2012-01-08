package com.github.lang.easylunch.service;

import com.github.lang.easylunch.domain.Benutzer;

public interface BenutzerService {

    /**
     * Returns the currently logged in Benutzer or null if no Benutzer
     * is logged in.
     */
    Benutzer currentBenutzer();

    /**
     * Updates the persisted (hashed) password properties of benutzer
     * from the given cleartext password. Sets benutzer.passwordSalt
     * first if it is null.
     */
    void updatePassword(Long benutzerId, String cleartextPassword);

}
