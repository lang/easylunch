<#escape x as x?html>
<@standard_page>

    <@page_main>

        <h2>Benutzer bearbeiten</h2>

        <form method="post">
            <input type="hidden" name="id" value="${benutzer.id}"/>
            <#include "_form.ftl">
        </form>

    </@page_main>

</@standard_page>
</#escape>
