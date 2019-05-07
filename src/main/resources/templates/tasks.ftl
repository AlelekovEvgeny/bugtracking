<#import "parts/pager.ftl" as p>

<div>
    <form method="post" action="addTask">
        <input type="text" name="nameTask" placeholder="Введите название задачи" />
        <input type="text" name="discriptionTask" placeholder="Введите описание задачи">
        <input type="text" name="priorityTask" placeholder="Введите приоритет задачи">
        <input type="text" name="statusTask" placeholder="Введите статус проекта">
        <input type="text" name="requestProject" placeholder="Введите идентификатор проекта">
        <input type="date" name="dateCreateTask" placeholder="Введите дату создания проекта">
        <input type="date" name="dateUpdateTask" placeholder="Введите дату обновления проекта">
        <button type="submit">Добавить</button>
    </form>
</div>
<div>Список задач</div>
<@p.pager url page />
<a href="tasksDateSort">Отсортировать по дате</a>

<div class="card-columns" id="task-list">
    <#list page.content as task>
        <div class="card my-3" data-id="${task.id}">
            <div class="m-2">
                <b>${task.id}</b>
                <span>${task.nameTask}</span><br/>
                <i>#${task.discriptionTask}</i>
            </div>
        </div>
    <#else>
        No tasks
    </#list>
</div>
<@p.pager url page />
<a href="/">на главную</a>
