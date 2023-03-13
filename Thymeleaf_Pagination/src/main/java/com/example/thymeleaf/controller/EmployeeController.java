package com.example.thymeleaf.controller;

import com.example.thymeleaf.model.employeer;
import com.example.thymeleaf.service.EmployeeService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/")
    public String viewHomePage(Model model){
        return getPaginated(1,model);
    }
    @PostMapping("/addEmployeer")
    public String addEmployeer(@ModelAttribute("employeer") employeer toAdd){
        employeeService.saveEmployee(toAdd);
        return "redirect:/";
    }
    @DeleteMapping("/deleteEmployeer")
    public String DeleteEmployeer(@RequestParam("id") Long toDelete){
        employeeService.deleteById(toDelete);
        return "redirect:/";
    }
    @GetMapping("/page/{pageNum}")
    public String getPaginated(@PathVariable (value = "pageNum") int pageNum , Model model){
        employeer employeer =  new employeer();
        model.addAttribute("employeer",employeer);
        int pageSize = 4;
        Page<employeer> page = employeeService.findPaginated(pageNum,pageSize);
        List<employeer> ListEmployer = page.getContent();
        model.addAttribute("listEmployees", ListEmployer);
        model.addAttribute("currentPage",pageNum);
        model.addAttribute("TotalePages",page.getTotalPages());
        return "index";
    }
}
