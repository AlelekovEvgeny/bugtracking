package com.alelekov.bugtracking.controller;

import com.alelekov.bugtracking.entities.Tasks;
import com.alelekov.bugtracking.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    //ToDo решить проблему дублирования кода
    /**
     * сортировка задач по приоретету
     * пагинация*/
    @GetMapping("/tasks")
    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model,
                       @PageableDefault(sort = { "priorityTask" }, direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Tasks> page;

        if (filter != null && !filter.isEmpty()) {
            page = taskRepository.findByNameTask(filter, pageable);
        } else {
            page = taskRepository.findAll(pageable);
        }

        model.addAttribute("page", page);
        model.addAttribute("url", "/tasks");
        model.addAttribute("filter", filter);

        return "tasks";
    }

    /**
     * сортировка задач по дате создания
     * пагинация*/
    @GetMapping("/tasksDateSort")
    public String mainDateSort(@RequestParam(required = false, defaultValue = "") String filter, Model model,
                       @PageableDefault(sort = { "dateCreateTask" }, direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Tasks> page;

        if (filter != null && !filter.isEmpty()) {
            page = taskRepository.findByNameTask(filter, pageable);
        } else {
            page = taskRepository.findAll(pageable);
        }

        model.addAttribute("page", page);
        model.addAttribute("url", "/tasks");
        model.addAttribute("filter", filter);

        return "tasks";
    }

    /**
     * добавление задач*/
    @PostMapping("addTask")
    public String add(@RequestParam String nameTask, @RequestParam String discriptionTask, @RequestParam int priorityTask,
                      @RequestParam int statusTask, @RequestParam String dateCreateTask,
                      @RequestParam String dateUpdateTask, Map<String, Object> model) {
        Tasks task = new Tasks(nameTask, discriptionTask, priorityTask, statusTask, dateCreateTask, dateUpdateTask);

        taskRepository.save(task);

        Iterable<Tasks> tasks = taskRepository.findAll();

        model.put("tasks", tasks);

        return "tasks";
    }
}
