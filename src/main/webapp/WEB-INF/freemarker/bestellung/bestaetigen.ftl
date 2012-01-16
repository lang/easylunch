<#escape x as x?html>
<@standard_page>

    <@page_css "bestellung/bestaetigen.css"/>

    <@page_main>

        <table>
            <tr>
                <th>Speise</th>
                <th class="preis">Preis</th>
            </tr>
            <#list vorgemerkteSpeisen as speise>
                <tr>
                    <td>${speise.name}</td>
                    <td class="preis">€ ${speise.preis?string.currency}</td>
                </tr>
            </#list>
            <tr class="summe">
                <td>Summe</td>
                <td class="preis">€ ${vorgemerkteSumme?string.currency}</td>
            </tr>
        </table>

    </@page_main>

</@standard_page>
</#escape>
