<#import "parts/pager.ftl" as p>

<div>
    <form method="post">
        <input type="text" name="nameProject" placeholder="Введите название проекта" />
        <input type="text" name="discriptionProject" placeholder="Введите описание проекта">
        <button type="submit">Добавить</button>
    </form>
</div>
<div>Список проектов</div>
<form method="post" action="/main">
    <input type="text" name="filter" value="${filter}">
    <button type="submit">Найти</button>
</form>
<@p.pager url page />
<div class="card-columns" id="project-list">
    <#list page.content as project>
        <div class="card my-3" data-id="${project.id}">
            <div class="m-2">
                <b>${project.id}</b>
                <span>${project.nameProject}</span>
                <i>${project.discriptionProject}</i>
                <a href="project">посмотреть</a>
            </div>
        </div>
    <#else>
        No projects
    </#list>
</div>
<@p.pager url page />
<a href="/">на главную</a>