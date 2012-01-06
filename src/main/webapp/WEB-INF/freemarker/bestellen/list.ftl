<#escape x as x?html>
<@standard_page>

    <@page_main>
		<h2>Bestellungen verwalten</h2>
        <table>
            <tr>
                <th>Konsumationszeitpunkt</th>
                <th>Ausgabezeitpunkt</th>
                <th>Ausgabepreis</th>
                <th>Storniert</th>
                <th>Best&auml;tigt</th>
                <th></th>
            </tr>
            <#list bestellungen as bestellung>
                <tr>
                    <td>${bestellung.konsumationszeitpunkt}</td>
                    <td>${bestellung.ausgabezeitpunkt!}</td>
                    <td>${besetellung.ausgabepreis!}</td>
                    <td><#if bestellungen.storniert>X</#if></td>
                    <td><#if bestellungen.bestaetigt>X</#if></td>
            </#list>
        </table>
        
        <a class="buttonlink" href="<@app_url '/wui/bestellen/create'/>">Neue Bestellung</a>

    </@page_main>

</@standard_page>
</#escape>
