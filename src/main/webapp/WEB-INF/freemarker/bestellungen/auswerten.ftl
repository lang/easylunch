<#escape x as x?html>
<#include "bestellungenUtils.ftl">

<@standard_page>

    <@page_main>
		<h2>Bestellungsauswertung f&uuml;r ${date}</h2>
		<form method="post" action="bestellungen/applyToStock">
	        <table>
        		<@bestellungsauswertung_tableHead_clean>
    	    	</@bestellungsauswertung_tableHead_clean>
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
    		    <a class="buttonlink" href="<@app_url '/wui/bestellungen/printPreview'/>">Druckansicht</a>
		        <#if compliable>
			        <button class="buttonlink" type="submit">Speisenausgabe in Lagerstand übernehmen</button>
		        <#else>
			        <button class="btn" class="buttonlink" type="submit" disabled>Speisenausgabe in Lagerstand übernehmen</button>
		        </#if>
	        </div>
        
        </form>
    </@page_main>

</@standard_page>
</#escape>
