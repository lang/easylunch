<#escape x as x?html>
<#macro print_items items include_bestellungen=true>
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
            <#if include_bestellungen>
                <div class="bestellungen">
                    <ul>
                        <#list item.bestellungen as bestellung>
                            <li>
                                ${bestellung.id}
                            </li>
                        </#list>
                    </ul>
                </div>
            </#if>
        </div>
    </#list>
</#macro>
</#escape>
