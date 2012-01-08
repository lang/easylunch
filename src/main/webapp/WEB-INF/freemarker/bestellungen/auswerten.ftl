<#escape x as x?html>
<@standard_page>

    <@page_main>
		<h2>Bestellungsauswertung f&uuml;r ${date}</h2>
        <table>
            <tr>
                <th>Speisen</th>
                <th>Bestellungen</th>
                <th>Lagerstand</th>
                <th>Differenz</th>
                <th></th>
            </tr>
            <#list bestellungen as bestellung>
                <tr>
                    <td>${bestellung.konsumationszeitpunkt}</td>
                    <td>${bestellung.ausgabezeitpunkt!}</td>
                    <td>${besetellung.ausgabepreis!}</td>
                    <td><#if bestellungen.storniert>X</#if></td>
            </#list>
        </table>
        
    </@page_main>

</@standard_page>
</#escape>
