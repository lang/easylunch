<#escape x as x?html>
<@standard_page>

    <@page_css "bestellung/speisen.css"/>

    <@page_main>

        <ul id="art_options">
            <li>
                <a href="?art=Vorspeise">Vorspeisen</a>
            </li>
            <li>
                <a href="?art=Hauptspeise">Hauptspeisen</a>
            </li>
            <li>
                <a href="?art=Nachspeise">Nachspeisen</a>
            </li>
        </ul>

        <h2>Bestellen - ${art}</h2>

        <#assign column_index = 0/>

        <#list speisen as speise>
            <div class="listitem speiseitem">
                <div class="bild">
                    <#if speise.bildId?has_content>
                        <img alt="${speise.name}"
                            src="<@app_url '/wui/speise/bild?id=${speise.id}'/>"/>
                    </#if>
                </div>
                <div class="name">
                    ${speise.name}
                </div>
                <div class="preis">
                <h4>Preis:</h4>
                    ${speise.preis?string.currency}
                </div>
                <div class="beschreibung">
                    ${speise.beschreibung!}
                </div>
                <form class="bestellen" method="post">
                    <input type="hidden" name="id" value="${speise.id}"/>
                    <@input_submit "Bestellen"/>
                </form>
            </div>

            <#assign column_index = column_index + 1/>
            <#if column_index = 2>
                <br/>
                <#assign column_index = 0/>
            </#if>
        </#list>

    </@page_main>

</@standard_page>
</#escape>
