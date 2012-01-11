<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />

<#assign page_content_header_ = ""/>
<#assign page_content_body_ = ""/>
<#assign page_content_title_ = "EasyLunch"/>

<#macro page_title title>
    <#assign page_content_title_ = title/>
</#macro>

<#macro page_content_header>
    <#assign page_content_header_>${page_content_header_}<#nested></#assign>
</#macro>

<#macro page_content_body>
    <#assign page_content_body_>${page_content_body_}<#nested></#assign>
</#macro>

<#macro page_css filename media="screen">
    <@page_content_header>
        <link href="<@app_url '/public/css/wui/${filename}'/>" media="${media}" rel="stylesheet" type="text/css" />
    </@page_content_header>
</#macro>

<#macro html_page><#t>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8"/>
        <title>${page_content_title_?html}</title>
        ${page_content_header_}
    </head>
    <body>
        ${page_content_body_}
    </body>
</html>
</#macro>

<#assign page_main_ = ""/>

<#macro page_main>
    <#assign page_main_><#nested></#assign>
</#macro>

<#macro standard_page>
    <#nested><#t>
    <@page_css "standard_page.css"/>
    <@page_content_body><#t>
    	<div id="wrapper">
        <div id="header">
            
        </div>
        <#include "standard_top_nav.ftl"/>
        <div id="main">${page_main_}</div>
        <div id="footer">
        <@security.authorize ifAnyGranted="ROLE_USER">
                Angemeldet als <@security.authentication property="principal.username"/>
                <a href="<@app_url '/j_spring_security_logout'/>">Abmelden</a>
            </@security.authorize>
        </div>
        
        </div>
        
    </@page_content_body><#t>
    <@html_page/><#t>
</#macro>
