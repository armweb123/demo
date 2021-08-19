package com.example.demo.controller;

import com.example.demo.model.Companies;
import com.example.demo.model.Employees;
import com.example.demo.repository.CompaniesRepository;
import com.example.demo.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmployeesController {
    @Autowired
    EmployeesRepository employeesRepository;

    @Autowired
    CompaniesRepository companiesRepository;

    @GetMapping("/employees")
    public String employees(ModelMap modelMap) {
        List<Employees> employees = employeesRepository.findAll();
        modelMap.addAttribute("employ", employees);
        return "empl";
    }

    @GetMapping("/employees/add")
    public String addEmpl(ModelMap modelMap) {
        List<Companies> all = companiesRepository.findAll();
        modelMap.addAttribute("employee", new Employees());
        modelMap.addAttribute("company", all);
        return "addEmpl";
    }

    @PostMapping("/employees/add")
    public String addEmpl(@ModelAttribute Employees employees) {
        employeesRepository.save(employees);
        return "redirect:/employees";
    }
}
