package com.example.demo.controller;

import com.example.demo.model.Companies;
import com.example.demo.repository.CompaniesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CompaniesController {

    @Autowired
    private CompaniesRepository companiesRepository;

    @GetMapping("/companies")
    public String companies(ModelMap modelMap) {
        List<Companies> all = companiesRepository.findAll();
        modelMap.addAttribute("comps", all);
        return "comp";
    }

    @GetMapping("/companies/add")
    public String addComp() {
        return "addComps";
    }

    @PostMapping("/companies/add")
    public String addCompPost(@ModelAttribute Companies companies) {
        companiesRepository.save(companies);
        return "redirect:/companies";
    }

    @GetMapping("/companies/delete/{id}")
    public String deleteComp(@PathVariable("id") int id) {
        companiesRepository.deleteById(id);
        return "redirect:/companies";
    }
}
