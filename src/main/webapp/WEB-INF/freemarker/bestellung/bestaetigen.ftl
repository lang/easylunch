<#escape x as x?html>
<@standard_page>

    <@page_css "bestellung/bestaetigen.css"/>

    <@page_main>

        <h1>Vorgemerkt</h1>
        <#if vorgemerkteSpeisen?has_content>
            <table>
                <tr>
                    <th></th>
                    <th>Speise</th>
                    <th class="preis">Preis</th>
                </tr>
                <#list vorgemerkteSpeisen as speise>
                    <tr>
                        <td>
                            <form action="bestaetigen/remove" method="post">
                                <input type="hidden" name="id" value="${speise.id}"/>
                                <input type="submit" value="Entfernen"/>
                            </form>
                        </td>
                        <td>${speise.name}</td>
                        <td class="preis">€ ${speise.preis?string.currency}</td>
                    </tr>
                </#list>
                <tr class="summe">
                    <td></td>
                    <td>Summe</td>
                    <td class="preis">€ ${vorgemerkteSumme?string.currency}</td>
                </tr>
            </table>
            <form id="bestaetigen" method="post">
                Bestellen für
                <select name="date">
                    <#list dateOptions as option>
                        <option>${option}</option>
                    </#list>
                </select>
                <select name="time">
                    <#list timeOptions as option>
                        <option>${option}</option>
                    </#list>
                </select>
                <input type="submit" value="Bestätigen"/>
            </form>

            oder
            <a class="weitere_speisen" href="<@app_url '/wui/bestellung'/>">
                Weitere Speisen auswählen
            </a>
        <#else>
            <p>
                Keine Speisen ausgewählt
            </p>
            <a class="weitere_speisen" href="<@app_url '/wui/bestellung'/>">
                Speisen auswählen
            </a>
        </#if>

        <h1>Vorbestellt</h1>
        <#if bestellungen?has_content>
            <table id="bestellungen">
                <#assign lastks = ""/>
                <tbody>
                    <#list bestellungen as bestellung>
                        <#assign ks = bestellung.konsumationszeitpunkt?string("E, dd.MM.yyyy HH:mm")/>
                        <#if lastks?has_content && lastks != ks>
                            </tbody>
                            <tbody>
                        </#if>
                        <tr>
                            <td>
                                ${ks}
                            </td>
                            <td>
                                ${bestellung.speise.name}
                            </td>
                            <td>
                                € ${bestellung.ausgabepreis?string.currency}
                            </td>
                        </tr>
                        <#assign lastks = ks/>
                    </#list>
                </tbody>
            </table>
        <#else>
            <p>Keine Vorbestellungen vorhanden</p>
        </#if>



    </@page_main>

</@standard_page>
</#escape>
