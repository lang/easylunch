<#escape x as x?html>
<@input_text "Name" "speise.name"/>
<@input_textarea "Beschreibung" "speise.beschreibung"/>
<@input_select "Art" "speise.art" artOptions/>
<@input_text "Im Sortiment ab" "speise.imSortimentAb"/>
<@input_text "Im Sortiment bis" "speise.imSortimentBis"/>
<@input_text "Preis" "speise.preis"/>
<@input_text "Lagerstand" "speise.lagerstand"/>
<@input_submit/>
<@input_cancel/>
</#escape>
