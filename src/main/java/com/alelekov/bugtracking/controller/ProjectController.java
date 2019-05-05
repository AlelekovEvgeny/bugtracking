package com.alelekov.bugtracking.controller;

import com.alelekov.bugtracking.entities.Projects;
import com.alelekov.bugtracking.entities.Tasks;
import com.alelekov.bugtracking.repositories.ProjectRepository;
import com.alelekov.bugtracking.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import java.util.Optional;

@Controller
public class ProjectController {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @RequestMapping("project")
    public String home(){
        return "project";
    }

    @PostMapping("idProject")
    public String idProject(@RequestParam Long idProject, Map<String, Object> model, Map<String, Object> model2) {
        //Iterable<Projects> projects;
        Iterable<Tasks> tasks;


            //projects = projectRepository.findById(id);
            tasks = taskRepository.getAll(idProject);

        //model.put("projects", projects);
        model2.put("tasks", tasks);

        return "project";
    }
}
