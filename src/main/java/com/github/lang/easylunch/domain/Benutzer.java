package com.github.lang.easylunch.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;

public class Benutzer implements UserDetails {

    private static final GrantedAuthority ROLE_USER =
        new GrantedAuthorityImpl("ROLE_USER");

    private static final GrantedAuthority ROLE_GAST =
        new GrantedAuthorityImpl("ROLE_GAST");

    private static final GrantedAuthority ROLE_MITARBEITER =
        new GrantedAuthorityImpl("ROLE_MITARBEITER");

    private static final GrantedAuthority ROLE_VERWALTUNG =
        new GrantedAuthorityImpl("ROLE_VERWALTUNG");

    private Long id;
    @Size(min = 1, max = 255)
    private String benutzername;
    private String passwordHash;
    private String passwordSalt;
    /**
     * Not persistent, but useful for user interface code.
     */
    private String cleartextPassword;
    /**
     * Not persistent, but useful for user interface code.
     */
    private String cleartextPasswordRepeat;
    private boolean aktiv;
    @Size(max = 255)
    private String personalNummer;
    @Size(max = 255)
    private String titel;
    @Size(max = 255)
    private String vorname;
    @Size(min = 1, max = 255)
    private String nachname;
    private boolean istMitarbeiter;
    private boolean istVerwaltung;
    private boolean istGast;

    /**
     * Used for implementation of UserDetails interface.
     * Set on first call to getAuthorities().
     */
    private Collection<GrantedAuthority> authorities;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    
    public void setBenutzername(String benutzername) {
        this.benutzername = benutzername;
    }
    
    public String getBenutzername() {
        return benutzername;
    }
    
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
    
    public String getPasswordHash() {
        return passwordHash;
    }
    
    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }
    
    public String getPasswordSalt() {
        return passwordSalt;
    }
    
    public void setCleartextPassword(String cleartextPassword) {
        this.cleartextPassword = cleartextPassword;
    }

    public String getCleartextPassword() {
        return cleartextPassword;
    }
    
    public void setCleartextPasswordRepeat(String cleartextPasswordRepeat) {
        this.cleartextPasswordRepeat = cleartextPasswordRepeat;
    }
    
    public String getCleartextPasswordRepeat() {
        return cleartextPasswordRepeat;
    }

    public void setAktiv(boolean aktiv) {
        this.aktiv = aktiv;
    }

    public boolean getAktiv() {
        return aktiv;
    }
    
    public void setPersonalNummer(String personalNummer) {
        this.personalNummer = personalNummer;
    }
    
    public String getPersonalNummer() {
        return personalNummer;
    }
    
    public void setTitel(String titel) {
        this.titel = titel;
    }
    
    public String getTitel() {
        return titel;
    }
    
    public void setVorname(String vorname) {
        this.vorname = vorname;
    }
    
    public String getVorname() {
        return vorname;
    }
    
    public void setNachname(String nachname) {
        this.nachname = nachname;
    }
    
    public String getNachname() {
        return nachname;
    }
    
    public void setIstMitarbeiter(boolean istMitarbeiter) {
        this.istMitarbeiter = istMitarbeiter;
    }
    
    public boolean getIstMitarbeiter() {
        return istMitarbeiter;
    }
    
    public void setIstVerwaltung(boolean istVerwaltung) {
        this.istVerwaltung = istVerwaltung;
    }
    
    public boolean getIstVerwaltung() {
        return istVerwaltung;
    }
    
    public void setIstGast(boolean istGast) {
        this.istGast = istGast;
    }
    
    public boolean getIstGast() {
        return istGast;
    }

    /* implementation of spring security's UserDetails */

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        if(authorities == null) {
            List<GrantedAuthority> al = new ArrayList<GrantedAuthority>(4);
            al.add(ROLE_USER);
            if(istGast) {
                al.add(ROLE_GAST);
            }
            if(istMitarbeiter) {
                al.add(ROLE_MITARBEITER);
            }
            if(istVerwaltung) {
                al.add(ROLE_VERWALTUNG);
            }
            // assignment is atomic
            // by using a local variable during list construction,
            // the Benutzer instance stays thread-safe
            authorities = al;
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return passwordHash;
    }

    @Override
    public String getUsername() {
        return benutzername;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return aktiv;
    }

}
