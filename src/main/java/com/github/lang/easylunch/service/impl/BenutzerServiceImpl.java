package com.github.lang.easylunch.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.github.lang.easylunch.domain.Benutzer;
import com.github.lang.easylunch.persistence.BenutzerMapper;
import com.github.lang.easylunch.service.BenutzerService;

@Service("benutzerService")
public class BenutzerServiceImpl implements BenutzerService, UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private BenutzerMapper benutzerMapper;

    public Benutzer currentBenutzer() {
        Object principal =
            SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof Benutzer) {
            return (Benutzer)principal;
        }
        return null;
    }

    public void updatePassword(Long benutzerId, String cleartextPassword) {
        Benutzer benutzer = benutzerMapper.getById(benutzerId);
        if(benutzer.getPasswordSalt() == null) {
            benutzer.setPasswordSalt(Double.toString(Math.random()));
        }
        benutzer.setPasswordHash(
            passwordEncoder.encodePassword(
                cleartextPassword, benutzer.getPasswordSalt()));
        benutzerMapper.update(benutzer);
    }

    /* implementation of spring security's UserDetailsService */

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Benutzer benutzer = benutzerMapper.findByBenutzername(username);
        if(benutzer == null) {
            throw new UsernameNotFoundException(
                "there is no user with name " + username);
        }
        return benutzer;
    }

}
