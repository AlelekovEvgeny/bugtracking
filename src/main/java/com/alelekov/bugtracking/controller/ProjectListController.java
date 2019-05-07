package com.alelekov.bugtracking.controller;

import com.alelekov.bugtracking.entities.Projects;
import com.alelekov.bugtracking.repositories.ProjectRepository;
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
public class ProjectListController {

    @Autowired
    private ProjectRepository projectRepository;

    @GetMapping("/main")
    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model,
                      @PageableDefault(sort = { "id" }, direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Projects> page;

        if (filter != null && !filter.isEmpty()) {
            page = projectRepository.findByNameProject(filter, pageable);
        } else {
            page = projectRepository.findAll(pageable);
        }

        model.addAttribute("page", page);
        model.addAttribute("url", "/main");
        model.addAttribute("filter", filter);

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
}
