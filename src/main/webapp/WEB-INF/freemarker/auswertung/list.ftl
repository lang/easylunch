<#escape x as x?html>
<@standard_page>

    <@page_css "auswertung/list.css"/>

    <@page_main>

        <#list auswertungItems as item>
            <div class="auswertung_item">
                <div class="speise_name">
                    ${item.speise.name}
                </div>
                <div class="bestellmenge">
                    ${item.bestellungen?size}
                </div>
                <div class="lagerstand">
                    ${item.speise.lagerstand}
                </div>
                <div class="lagerdiff">
                    ${item.lagerdiff}
                </div>
                <div class="bestellungen">
                    <ul>
                        <#list item.bestellungen as bestellung>
                            <li>
                                ${bestellung.id}
                            </li>
                        </#list>
                    </ul>
                </div>
            </div>
        </#list>

    </@page_main>

</@standard_page>
</#escape>
