<#macro app_url url_suffix><@spring.url url_suffix/></#macro>

<#macro input_cancel>
    <input type="submit" name="cancel" value="Abbrechen"/>
</#macro>

<#macro input_submit>
    <input type="submit" name="submit" value="Übernehmen"/>
</#macro>

<#macro standard_form_item attr>
    <@spring.bind attr/>
    <div class="standard_form_item">
        <#if spring.status.errorMessages?size != 0>
            <div class="errors">
                <@spring.showErrors "<br/>"/>
            </div>
        </#if>
        <#nested>
    </div>
</#macro>

<#macro input_text label attr>
    <@standard_form_item attr>
        <label for="${spring.status.expression?html}">${label?html}:</label>
        <@spring.formInput attr/>
    </@standard_form_item>
</#macro>

<#macro input_checkbox label attr>
    <@standard_form_item attr>
        <@spring.formCheckbox attr/>
        <label for="${spring.status.expression?html}">${label?html}</label>
    </@standard_form_item>
</#macro>
