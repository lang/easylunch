<#escape x as x?html>
<@standard_page>

    <@page_main>

        <table>
            <tr>
                <th>Benutzername</th>
                <th>Name</th>
                <th>Gast</th>
                <th>Mitarbeiter</th>
                <th>Verwaltung</th>
                <th>Aktiv</th>
            </tr>
            <#list benutzerList as benutzer>
                <tr>
                    <td>${benutzer.benutzername}</td>
                    <td>
                        ${benutzer.titel!}
                        ${benutzer.vorname!}
                        ${benutzer.nachname!}
                    </td>
                    <td>
                        <#if benutzer.istGast>X</#if>
                    </td>
                    <td>
                        <#if benutzer.istMitarbeiter>X</#if>
                    </td>
                    <td>
                        <#if benutzer.istVerwaltung>X</#if>
                    </td>
                    <td>
                        <#if benutzer.aktiv>X</#if>
                    </td>
                </tr>
            </#list>
        </table>

        <a href="<@app_url '/wui/benutzer/create'/>">Neuer Benutzer</a>

    </@page_main>

</@standard_page>
</#escape>
