<#include "print_items.ftl"/>
<#escape x as x?html>
<@standard_page>

    <@page_css "auswertung/list.css"/>

    <@page_main>

        <a href="auswertung/print">Druckansicht</a>

        <@print_items auswertungItems/>

    </@page_main>

</@standard_page>
</#escape>
