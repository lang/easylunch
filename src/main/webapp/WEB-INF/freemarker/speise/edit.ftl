<#escape x as x?html>
<@standard_page>

    <@page_main>

        <h2>Speise bearbeiten: </h2>

        <form method="post" id="speise">
            <input type="hidden" name="id" value="${speise.id}"/>
            <#include "_form.ftl">
        </form>

    </@page_main>

</@standard_page>
</#escape>
