package com.alelekov.bugtracking.controller;

import com.alelekov.bugtracking.entities.Projects;
import com.alelekov.bugtracking.entities.Tasks;
import com.alelekov.bugtracking.repositories.ProjectRepository;
import com.alelekov.bugtracking.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private TaskRepository taskRepository;

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

    @PostMapping("tasks")
    public String add(@RequestParam String nameTask, @RequestParam String discriptionTask, @RequestParam int priorityTask,
                      @RequestParam int statusTask, @RequestParam int requestProject, Map<String, Object> model,
                      @RequestParam String dateCreateTask, @RequestParam String dateUpdateTask) {
        Tasks task = new Tasks(nameTask, discriptionTask, priorityTask, statusTask, dateCreateTask, dateUpdateTask);
        int idProject = requestProject;

        Projects projectTest = projectRepository.findById(idProject);

        task.setProjects(projectTest);
        taskRepository.save(task);

        Iterable<Tasks> tasks = taskRepository.findAll();

        model.put("tasks", tasks);

        return "main";
    }

    @DeleteMapping("deleteTask")
    public String delete(){
        Tasks task = new Tasks();
        taskRepository.delete(task);
        return "main";
    }
}
