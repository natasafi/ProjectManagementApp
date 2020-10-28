package com.natasafi.pma.controllers;

import com.natasafi.pma.entities.Employee;
import com.natasafi.pma.entities.Project;
import com.natasafi.pma.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;

    @GetMapping
    public String displayProjects(Model model) {
        List<Project> projects= projectRepository.findAll();

        model.addAttribute("projects", projects);

        return "projects/listProjects";
    }

    @GetMapping("/new")
    public String displayProjectForm(Model model) {
        Project project = new Project();

        model.addAttribute("project", project);

        return "projects/newProject";
    }

    @PostMapping("/save")
    public String createProject(Project project, Model model) {
        projectRepository.save(project);

        return "redirect:new";
    }
}
