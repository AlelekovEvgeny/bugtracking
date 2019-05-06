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
    <#--<#list page.projects as project>
    <div>
        <b>${project.id}</b>
        <span>${project.nameProject}</span>
        <i>${project.discriptionProject}</i>
        <a href="project">посмотреть</a>
    </div>
    <#else>
No projects
    </#list>-->
<div class="card-columns" id="project-list">
    <#list page.content as project>
        <div class="card my-3" data-id="${project.id}">
            <#--<#if project.filename??>
                <img src="/img/${message.filename}" class="card-img-top" />
            </#if>-->
            <div class="m-2">
                <span>${project.nameProject}</span><br/>
                <i>#${project.discriptionProject}</i>
            </div>
        </div>
    <#else>
        No message
    </#list>
</div>
<@p.pager url page />
<a href="/">на главную</a>
