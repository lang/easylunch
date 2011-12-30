<#macro app_url url_suffix><@spring.url url_suffix/></#macro>

<#macro input_cancel>
    <input type="submit" name="cancel" value="Abbrechen"/>
</#macro>

<#macro input_submit>
    <input type="submit" name="submit" value="Übernehmen"/>
</#macro>

<#macro input_text label attr>
    <div class="standard_form_item">
        <label for="${attr?html}">${label?html}:</label>
        <@spring.formInput attr/>
    </div>
</#macro>

<#macro input_checkbox label attr>
    <div class="standard_form_item">
        <@spring.formCheckbox attr/>
        <label for="${attr?html}">${label?html}</label>
    </div>
</#macro>
