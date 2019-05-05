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
public class TaskController {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("tasks")
    public String main(Map<String, Object> model) {
        Iterable<Tasks> tasks = taskRepository.findAll();

        model.put("tasks", tasks);

        return "tasks";
    }

/*    @PostMapping("tasks")
    public String add(@RequestParam String nameTask, @RequestParam String discriptionTask, Map<String, Object> model) {
        Tasks task = new Tasks(nameTask, discriptionTask);

        taskRepository.save(task);

        Iterable<Tasks> tasks = taskRepository.findAll();

        model.put("tasks", tasks);

        return "tasks";
    }*/

    /*@PostMapping("addTask")
    public String add(@RequestParam String nameTask, @RequestParam String discriptionTask, @RequestParam int priorityTask,
                      @RequestParam int statusTask, @RequestParam int requestProject,
                      @RequestParam String dateCreateTask, @RequestParam String dateUpdateTask, Map<String, Object> model) {
        Tasks task = new Tasks(nameTask, discriptionTask, priorityTask, statusTask, dateCreateTask, dateUpdateTask);
        int idProject = requestProject;

        Projects projectTest = projectRepository.findById(idProject);

        task.setProjects(projectTest);
        taskRepository.save(task);

        Iterable<Tasks> tasks = taskRepository.findAll();

        model.put("tasks", tasks);

        return "tasks";
    }*/

/*    @DeleteMapping("deleteTask")
    public String delete(){
        Tasks task = new Tasks();
        taskRepository.delete(task);
        return "tasks";
    }*/
}
