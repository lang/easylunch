<#include "print_items.ftl"/>
<#escape x as x?html>
<@print_page>

    <@page_css "auswertung/list_print.css"/>

    <@page_main>

        <@print_items auswertungItems false/>

    </@page_main>

</@print_page>
</#escape>
