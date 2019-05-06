<#import "parts/common.ftl" as c>

<@c.page>
<!--<div>
    <form method="post" action="addTask">
        <input type="text" name="nameTask" placeholder="Введите название задачи" />
        <input type="text" name="discriptionTask" placeholder="Введите описание задачи">
        <input type="text" name="priorityTask" placeholder="Введите приоритет задачи">
        <input type="text" name="statusTask" placeholder="Введите статус проекта">
        <input type="text" name="requestProject" placeholder="Введите идентификатор проекта">
        <input type="text" name="dateCreateTask" placeholder="Введите дату создания проекта">
        <input type="text" name="dateUpdateTask" placeholder="Введите дату обновления проекта">
        <button type="submit">Добавить</button>
    </form>
</div>-->
<div>Список задач</div>
<!--<form method="post" action="filterTasks">
    <input type="nameTask" name="filter">
    <button type="submit">Найти</button>
</form>-->
    <#list tasks as task>
    <div>
        <b>${task.id}</b>
        <span>${task.nameTask}</span>
        <i>${task.discriptionTask}</i>
    </div>
    <#else>
No tasks
    </#list>
<a href="/">на главную</a>
</@c.page>