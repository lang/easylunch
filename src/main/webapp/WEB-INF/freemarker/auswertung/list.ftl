<#include "print_items.ftl"/>
<#escape x as x?html>
<@standard_page>

    <@page_css "auswertung/list.css"/>

    <@page_main>

        

    <a id="druckansicht" href="auswertung/print">Druckansicht</a>
    <div id="items">
        <@print_items auswertungItems/>
    </div>

    </@page_main>

</@standard_page>
</#escape>
