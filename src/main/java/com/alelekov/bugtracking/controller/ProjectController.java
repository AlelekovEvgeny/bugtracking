package com.alelekov.bugtracking.controller;

import com.alelekov.bugtracking.entities.Tasks;
import com.alelekov.bugtracking.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class ProjectController {

    @Autowired
    private TaskRepository taskRepository;

    /**
     * для поподания на страницу списка задач конкретного проекта*/
    @RequestMapping("/project")
    public String home(){
        return "project";
    }

    /**
     * вывод списка задач для выбронного проекта по ID*/
    @PostMapping("/idProject")
    public String idProject(@RequestParam Long idProject, Map<String, Object> model2) {
        Iterable<Tasks> tasks;

            tasks = taskRepository.getAll(idProject);

        model2.put("tasks", tasks);

        return "project";
    }
}
