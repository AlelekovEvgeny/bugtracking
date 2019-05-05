package com.alelekov.bugtracking.controller;

import com.alelekov.bugtracking.entities.Projects;
import com.alelekov.bugtracking.repositories.ProjectRepository;
import com.alelekov.bugtracking.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class ProjectListController {

    @Autowired
    private ProjectRepository projectRepository;

  /*  @GetMapping("index")
    public String start() {

        return "index";
    }*/

    @GetMapping
    public String main(Map<String, Object> model) {
        Iterable<Projects> projects = projectRepository.findAll();

        model.put("projects", projects);

        return "main";
    }

    @PostMapping
    public String add(@RequestParam String nameProject, @RequestParam String discriptionProject, Map<String, Object> model) {
        Projects project = new Projects(nameProject, discriptionProject);

        projectRepository.save(project);

        Iterable<Projects> projects = projectRepository.findAll();

        model.put("projects", projects);

        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        Iterable<Projects> projects;

        if (filter != null && !filter.isEmpty()) {
            projects = projectRepository.findByNameProject(filter);
        } else {
            projects = projectRepository.findAll();
        }

        model.put("projects", projects);

        return "main";
    }
}
