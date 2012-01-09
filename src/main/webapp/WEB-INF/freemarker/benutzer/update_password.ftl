<#escape x as x?html>
<@standard_page>

    <@page_main>

        <h2>Passwort für Benutzer ${benutzer.benutzername}</h2>

        <form method="post">
            <input type="hidden" name="id" value="${benutzer.id}"/>
            <@input_text "Neues Passwort"
                "benutzer.cleartextPassword" "password"/>
            <@input_text "Neues Passwort wiederholen"
                "benutzer.cleartextPasswordRepeat" "password"/>
            <@input_submit/>
            <@input_cancel/>
        </form>

    </@page_main>

</@standard_page>
</#escape>
