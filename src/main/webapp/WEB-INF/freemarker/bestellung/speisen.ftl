<#escape x as x?html>
<@standard_page>

    <@page_css "bestellung/speisen.css"/>

    <@page_main>

        <ul id="art_options">
            <#list artOptions?keys as key>
                <li <#if key == art>id="active_art_option"</#if>>
                    <a href="?art=${key}">${artOptions[key]}</a>
                </li>
            </#list>
        </ul>

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
