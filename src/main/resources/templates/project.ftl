<div>введите номер проекта</div>
<form method="post" action="idProject">
    <input type="number" name="idProject">
    <button type="submit">Найти</button>
</form>
<div class="card-columns" id="task-list">
<#if tasks??>
    <#list tasks as task>
        <div>
            <b>${task.id}</b>
            <span>${task.nameTask}</span>
            <i>${task.discriptionTask}</i>
        </div>
    <#else>
No tasks
    </#list>
<#else>
    No tasks
</#if>
</div>
<br>
<a href="main">к списку проектов</a>
<br>
<a href="/">на главную</a>