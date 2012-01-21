<#escape x as x?html>
<@standard_page>

    <@page_css "bestellung/bestaetigen.css"/>

    <@page_main>

        <h1>Vorgemerkt</h1>
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
            <label>
                Bestellen für
                <input type="datetime-local" name="date"/>
            </label>
            <input type="submit" value="Bestätigen"/>
        </form>

        <h1>Vorbestellt</h1>
        <#if !bestellungen?has_content>
            <p>Keine Vorbestellungen vorhanden</p>
        </#if>

    </@page_main>

</@standard_page>
</#escape>
