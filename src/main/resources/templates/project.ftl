<#import "parts/common.ftl" as c>

<@c.page>
<div>введите номер проекта</div>
<form method="post" action="idProject">
    <input type="number" name="idProject">
    <button type="submit">Найти</button>
</form>
    <#list tasks as task>
    <div>
        <b>${task.id}</b>
        <span>${task.nameTask}</span>
        <i>${task.discriptionTask}</i>
    </div>
    <#else>
No tasks
    </#list>
<br>
<a href="main">к списку проектов</a>
<br>
<a href="/">на главную</a>
</@c.page>