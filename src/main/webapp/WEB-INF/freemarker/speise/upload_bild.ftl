<#escape x as x?html>
<@standard_page>

    <@page_css "speise/list.css"/>

    <@page_main>

        <h2>Bild für &quot;${speise.name}&quot; hochladen</h2>

        <form method="post" enctype="multipart/form-data">
            <input type="hidden" name="id" value="${speise.id}"/>
            <input type="file" name="file"/>
            <br/>
            <@input_submit/>
        </form>

    </@page_main>

</@standard_page>
</#escape>
