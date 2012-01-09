<#escape x as x?html>
<@standard_page>

    <@page_main>

        <form id="login" action="<@app_url '/j_spring_security_check'/>" method="post">
            <div class="standard_form_item">
                <label for="j_username">Benutzername:</label>
                <input type="text" name="j_username" value="${j_username!}"/>
            </div>
            <div class="standard_form_item">
                <label for="j_username">Benutzername:</label>
                <input type="password" name="j_password" value=""/>
            </div>
            <input type="submit" class="btn" value="Anmelden"/>
        </form>

    </@page_main>

</@standard_page>
</#escape>
