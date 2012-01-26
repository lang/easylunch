<#escape x as x?html>
<#macro print_items items include_bestellungen=true>
    <div class="auswertung_item auswertung_head">
        <div class="speise_name">
            Speise
        </div>
        <div class="bestellmenge">
            Best.Menge
        </div>
        <div class="lagerstand">
            Lagerst.
        </div>
        <div class="lagerdiff">
            Diff.
        </div>
    </div>
    <#list auswertungItems as item>
        <div class="auswertung_item">
            <div class="speise_name">
                ${item.speise.name}
            </div>
            <div class="bestellmenge">
                ${item.count}
            </div>
            <div class="lagerstand">
                ${item.speise.lagerstand}
            </div>
            <div class="lagerdiff">
                ${item.lagerdiff}
            </div>
            <#if include_bestellungen>
                <div class="bestellungen">
                    <ul>
                        <#list item.bestellungen as bestellung>
                            <li>
                                <div class="konsumationszeitpunkt">
                                    ${bestellung.konsumationszeitpunkt?string("HH:mm")}
                                </div>
                                <div class="benutzer" title="Benutzername: ${bestellung.benutzer.benutzername}">
                                    ${bestellung.benutzer.nachname}<#t>
                                    <#if bestellung.benutzer.titel?has_content || bestellung.benutzer.vorname?has_content><#t>
                                        , ${bestellung.benutzer.titel!} ${bestellung.benutzer.vorname!}<#t>
                                    </#if>
                                    <#if bestellung.benutzer.personalNummer?has_content>
                                        (${bestellung.benutzer.personalNummer})
                                    </#if>
                                </div>
                                <div class="bcontrols">
                                    <div class="bestaetigen">
                                        <#if bestellung.bestaetigt>
                                            Bestätigt
                                        <#elseif !bestellung.storniert>
                                            <form action="auswertung/bestellung/bestaetigen" method="post" class="bestaetigen">
                                                <input type="hidden"  name="id" value="${bestellung.id}"/>
                                                <input type="submit" class="btn" value="Bestätigen"/>
                                            </form>
                                        </#if>
                                    </div>
                                    <div class="stornieren">
                                        <#if bestellung.storniert>
                                            Storniert
                                        <#else>
                                            <form action="auswertung/bestellung/stornieren" method="post" class="stornieren">
                                                <input type="hidden" name="id" value="${bestellung.id}"/>
                                                <input type="submit" class="btn" value="Stornieren"/>
                                            </form>
                                        </#if>
                                    </div>
                                </div>
                            </li>
                        </#list>
                    </ul>
                </div>
            </#if>
        </div>
    </#list>
</#macro>
</#escape>
