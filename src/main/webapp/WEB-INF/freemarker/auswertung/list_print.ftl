<#include "print_items.ftl"/>
<#escape x as x?html>
<@print_page>

    <@page_css "auswertung/list_print.css"/>

    <@page_main>

        <h1>
            Bestellungsauswertung ${date?string("EEEE, dd.MM.yyyy HH:mm")}
        </h1>

        <@print_items auswertungItems false/>

    </@page_main>

</@print_page>
</#escape>
