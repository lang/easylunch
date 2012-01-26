<#escape x as x?html>
<@standard_page>
    <@page_css "bestellung/historie.css"/>

    <@page_main>

        <form method="get">
            Monat
            <select name="ym">
                <#list monthOptions as date>
                    <option value="${date?string('yyyy-MM')}">
                        ${date?string('MMMM yyyy')}
                    </option>
                </#list>
            </select>
            <input type="submit" class="btn" value="Anzeigen"/>
        </form>

        <h1 id="month">${month?string('MMMM yyyy')}</h1>

        <table>
            <#list bestellungen as bestellung>
                <tr>
                    <td>${bestellung.konsumationszeitpunkt?string('E, dd HH:mm')}</td>
                    <td>${bestellung.speise.name}</td>
                    <td>${bestellung.ausgabepreis?string.currency}</td>
                </tr>
            </#list>
        </table>
        <p id="summe">
            Summe: ${sum?string.currency}
        </p>

    </@page_main>

</@standard_page>
</#escape>
