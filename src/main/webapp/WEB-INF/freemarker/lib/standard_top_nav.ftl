<#escape x as x?html>
<div id="top_nav">
    <ul>
        <li>
            <a href="<@app_url '/wui/bestellen'/>">Bestellen</a>
        </li>
        <li>
            <#-- TODO: show only for authorized users -->
            <a href="<@app_url '/wui/speise'/>">Speisen</a>
        </li>
        <li>
            <#-- TODO: show only for authorized users -->
            <a href="<@app_url '/wui/benutzer'/>">Benutzer verwalten</a>
        </li>
    </ul>
</div>
</#escape>
