<#escape x as x?html>
<@standard_page>

    <@page_css "speise/list.css"/>

    <@page_main>
        <br/>
        <h2>Speisen verwalten</h2>
        <a class="buttonlink" href="<@app_url '/wui/speise/create'/>">Neue Speise</a>

        <div class="listitem headitem speiseitem">
            <div class="bild">
                Bild
            </div>
            <div class="name">
                Name
            </div>
            <div class="lagerstand">
                Lagerstand
            </div>
            <div class="preis">
                Preis
            </div>
            <div class="im_sortiment">
                Im Sortiment
            </div>
        </div>

        <#list speisen as speise>
            <div class="listitem speiseitem">
                <div class="bild">
                    <#if speise.bildId?has_content>
                        <img alt="Bild ${speise.name}"
                            src="<@spring.url '/wui/speise/bild?id=${speise.id}'/>"/>
                    </#if>
                </div>
                <div class="name">
                    <a href="<@app_url '/wui/speise/show?id=${speise.id}'/>">
                        ${speise.name}
                    </a>
                </div>
                <div class="lagerstand">
                    ${speise.lagerstand} x
                </div>
                <div class="preis">
                    € ${speise.preis}
                </div>
                <div class="im_sortiment">
                    ${speise.imSortimentAb?string("dd.MM.yyyy")} -
                    ${speise.imSortimentBis?string("dd.MM.yyyy")}
                </div>
                <div class="controls">
                    <ul>
                        <li>
                            <a href="<@app_url '/wui/speise/edit?id=${speise.id}'/>">
                                Bearbeiten
                            </a>
                        </li>
                        <li>
                            <a href="<@app_url '/wui/speise/upload_bild?id=${speise.id}'/>">
                                Bild hochladen
                            </a>
                        </li>
                        <li>
                            <a href="<@app_url '/wui/speise/delete?id=${speise.id}'/>">
                                Löschen
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </#list>

        

    </@page_main>

</@standard_page>
</#escape>
