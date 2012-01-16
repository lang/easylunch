<#escape x as x?html>
<div id="top_nav">
    <ul>
        <@security.authorize ifAnyGranted="ROLE_GAST">
            <li>
                <a href="<@app_url '/wui/bestellung'/>">Bestellen</a>
            </li>
            <li>
                <a href="<@app_url '/wui/bestellung/bestaetigen'/>">Vorbestellungen</a>
            </li>
        </@security.authorize>
        <@security.authorize ifAnyGranted="ROLE_MITARBEITER">
            <li>
                <a href="<@app_url '/wui/speise'/>">Speisen verwalten</a>
            </li>
        </@security.authorize>
        <@security.authorize ifAnyGranted="ROLE_MITARBEITER">
            <li>
                <a href="<@app_url '/wui/bestellungen'/>">Bestellungen auswerten</a>
            </li>
        </@security.authorize>
        <@security.authorize ifAnyGranted="ROLE_VERWALTUNG">
            <li>
                <a href="<@app_url '/wui/benutzer'/>">Benutzer verwalten</a>
            </li>
        </@security.authorize>
    </ul>
            <@security.authorize ifAnyGranted="ROLE_USER">
                <a id='logout' href="<@app_url '/j_spring_security_logout'/>"><img src='/public/images/logout2black15.png' alt='Logout'/></a>
            </@security.authorize>
    
</div>
</#escape>
