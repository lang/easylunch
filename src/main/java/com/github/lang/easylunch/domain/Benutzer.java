package com.github.lang.easylunch.domain;

public class Benutzer {

    private Long id;
    private String benutzername;
    private String passwordHash;
    private String passwordSalt;
    /**
     * Not persistent, but useful for user interface code.
     */
    private String password;
    /**
     * Not persistent, but useful for user interface code.
     */
    private String passwordRepeat;
    private boolean aktiv;
    private String personalNummer;
    private String titel;
    private String vorname;
    private String nachname;
    private boolean istMitarbeiter;
    private boolean istVerwaltung;
    private boolean istGast;

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
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPasswordRepeat(String passwordRepeat) {
        this.passwordRepeat = passwordRepeat;
    }

    public String getPasswordRepeat() {
        return passwordRepeat;
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

}
