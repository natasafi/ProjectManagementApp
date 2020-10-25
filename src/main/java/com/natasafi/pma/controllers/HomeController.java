package com.natasafi.pma.controllers;

import com.natasafi.pma.entities.Employee;
import com.natasafi.pma.entities.Project;
import com.natasafi.pma.repository.EmployeeRepository;
import com.natasafi.pma.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/")
    public String displayHomePage(Model model) {
        List<Project> projects = projectRepository.findAll();
        //links it to the HTML attribute
        model.addAttribute("projects", projects);

        List<Employee> employees = employeeRepository.findAll();
        model.addAttribute("employees", employees);

        return "home";
    }

}
