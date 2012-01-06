<#escape x as x?html>
<@standard_page>

    <@page_main>

        <h2>Speisen verwalten</h2>

        <table>
            <tr>
                <th>Name</th>
                <th>Lagerstand</th>
                <th>Im Sortiment</th>
                <th></th>
            </tr>
            <#list speisen as speise>
                <tr>
                    <td>
                        <a href="<@app_url '/wui/speise/show?id=${speise.id}'/>">
                            ${speise.name}
                        </a>
                    </td>
                    <td>
                        ${speise.lagerstand}
                    </td>
                    <td>
                        ${speise.imSortimentAb?string("dd.MM.yyyy")} -
                        ${speise.imSortimentBis?string("dd.MM.yyyy")}
                    </td>
                    <td>
                        <a href="<@app_url '/wui/speise/edit?id=${speise.id}'/>">
                            Bearbeiten
                        </a>
                        <a href="<@app_url '/wui/speise/delete?id=${speise.id}'/>">
                            Löschen
                        </a>
                    </td>
                </tr>
            </#list>
        </table>

        <a class="buttonlink" href="<@app_url '/wui/speise/create'/>">Neue Speise</a>

    </@page_main>

</@standard_page>
</#escape>
