package com.natasafi.pma.controllers;

import com.natasafi.pma.entities.Employee;
import com.natasafi.pma.entities.Project;
import com.natasafi.pma.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/new")
    public String displayEmployeeForm(Model model) {
        Employee employee = new Employee();

        model.addAttribute("employee", employee);

        return "newEmployee";
    }

    @PostMapping("/save")
    public String createEmployee(Model model, Employee employee) {
        employeeRepository.save(employee);

        return "redirect:employees/new";
    }
}
