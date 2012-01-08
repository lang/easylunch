<#escape x as x?html>
<#include "*/bestellungenUtils.ftl">

<@standard_page>

    <@page_main>
		<h2>Bestellungsauswertung f&uuml;r ${date}</h2>
        <table>
        	<@bestellungsauswertung_tableHead_withActions>
        	</@bestellungsauswertung_tableHead_withActions>
            <#list bestellungen as bestellung>
                <tr>
                    <td>${bestellung.konsumationszeitpunkt}</td>
                    <td>${bestellung.ausgabezeitpunkt!}</td>
                    <td>${besetellung.ausgabepreis!}</td>
                    <td><#if bestellungen.storniert>X</#if></td>
                </tr>
            </#list>
        </table>
        
        <div id="actions">
    	    <a class="buttonlink" href="<@app_url '/wui/bestellungen'/>">Zurück</a>
        </div>
        
    </@page_main>

</@standard_page>
</#escape>
