<#escape x as x?html>
<@standard_page>

    <@page_main>

        <h2>Benutzer ${benutzer.benutzername} löschen?</h2>

        <form method="post">
            <input type="hidden" name="id" value="${benutzer.id}"/>
            <@input_submit "Löschen"/>
            <@input_cancel/>
        </form>

    </@page_main>

</@standard_page>
</#escape>
