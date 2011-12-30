<#escape x as x?html>
<@input_text "Benutzername" "benutzer.benutzername"/>
<@input_text "Personal-Nummer" "benutzer.personalNummer"/>
<@input_text "Titel" "benutzer.titel"/>
<@input_text "Vorname" "benutzer.vorname"/>
<@input_text "Nachname" "benutzer.nachname"/>
<@input_checkbox "Ist Gast" "benutzer.istGast"/>
<@input_checkbox "Ist Mitarbeiter" "benutzer.istMitarbeiter"/>
<@input_checkbox "Ist Verwalter" "benutzer.istVerwaltung"/>
<@input_checkbox "Aktiv" "benutzer.aktiv"/>
<@input_submit/>
<@input_cancel/>
</#escape>
