<div>введите номер проекта</div>
<form method="post" action="idProject">
    <input type="number" name="idProject">
    <button type="submit">Найти</button>
</form>
<div class="card-columns" id="task-list">
<#if tasks??>
    <#list tasks as task>
        <div>
            <table>
                <tr>
                    <th>задача</th>
                    <th>описание</th>
                    <th>приоритет</th><th>дата создания</th>
                    <th>дата обновления</th>
                    <th>статус задачи</th>
                </tr>
                <tr>
                    <td><span>${task.nameTask}</span></td>
                    <td><i>${task.discriptionTask}</i></td>
                    <td><i>${task.priorityTask}</i></td>
                    <td><i>${task.dateCreateTask}</i></td>
                    <td><i>${task.dateUpdateTask}</i></td>
                    <td><i>${task.statusTask}</i></td>
                </tr>
            </table>
        </div>
    <#else>
No tasks
    </#list>
<#else>
    No tasks
</#if>
</div>
<br>
Справочник статусов:
<br>
1 - «НОВАЯ»
<br>
2 - «В РАБОТЕ»
<br>
3 - «ЗАКРЫТА»
<br>
<br>
<a href="main">к списку проектов</a>
<br>
<a href="/">на главную</a>