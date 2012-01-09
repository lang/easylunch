<#escape x as x?html>
<div id="top_nav">
    <ul>
        <@security.authorize ifAnyGranted="ROLE_GAST">
            <li>
                <a href="<@app_url '/wui/bestellen'/>">Bestellen</a>
            </li>
        </@security.authorize>
        <@security.authorize ifAnyGranted="ROLE_MITARBEITER">
            <li>
                <a href="<@app_url '/wui/speise'/>">Speisen</a>
            </li>
        </@security.authorize>
        <@security.authorize ifAnyGranted="ROLE_MITARBEITER">
            <li>
                <#-- TODO: show only for authorized users -->
                <a href="<@app_url '/wui/bestellungen'/>">Bestellungen auswerten</a>
            </li>
        </@security.authorize>
        <@security.authorize ifAnyGranted="ROLE_VERWALTUNG">
            <li>
                <#-- TODO: show only for authorized users -->
                <a href="<@app_url '/wui/benutzer'/>">Benutzer verwalten</a>
            </li>
        </@security.authorize>
    </ul>
</div>
</#escape>
