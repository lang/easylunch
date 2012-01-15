<#escape x as x?html>
<@standard_page>

    <@page_main>

        <h2>Anwendungszeit</h2>

        <p>
            Für Simulations- und Testzwecke kann die Zeit für die
            Anwendung relativ zur Systemzeit um ein bestimmte Anzahl
            von Stunden nach vor oder nach hinten verschoben werden.
        </p>

        <hr/>

        <h3>
            ${systemTime?string("yyyy-MM-dd HH:mm:ss")} - Systemzeit
        </h3>
        <h3>
            ${applicationTime?string("yyyy-MM-dd HH:mm:ss")} - Anwendungszeit
        </h3>

        <hr/>

        <form method="post">
            Zeit um
            <input type="text" name="shiftHours" value=""/>
            Stunden verschieben.
            <br/>
            <@input_submit/>
        </form>

    </@page_main>

</@standard_page>
</#escape>
