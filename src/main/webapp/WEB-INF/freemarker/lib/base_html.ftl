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
    <@page_content_body><#t>
        <#include "standard_top_nav.ftl"/>
    </@page_content_body><#t>
    <@page_content_body><#t>
        <div id="main">${page_main_}</div>
    </@page_content_body><#t>
    <@html_page/><#t>
</#macro>
