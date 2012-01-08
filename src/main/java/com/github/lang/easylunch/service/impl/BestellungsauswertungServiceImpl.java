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

import com.github.lang.easylunch.service.BestellungsauswertungService;

import com.github.lang.easylunch.domain.Speise;
import com.github.lang.easylunch.domain.Bestellung;
import java.util.List;

@Service("bestellungsauswertungService")
public class BestellungsauswertungServiceImpl implements BestellungsauswertungService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private BenutzerMapper benutzerMapper;

    public boolean isOrderCompliable(List<Speise> mealList, List<Bestellung> orderList) {

        return false;
    }
}
