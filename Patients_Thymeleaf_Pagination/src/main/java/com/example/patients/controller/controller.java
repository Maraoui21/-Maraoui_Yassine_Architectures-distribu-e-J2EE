package com.example.patients.controller;

import com.example.patients.entities.Patients;
import com.example.patients.service.Impl.PatientsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.boot.Banner;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class controller {
    @Autowired
    PatientsServiceImpl patientsService;
    @GetMapping("/")
    public String Homapage(Model model){
        return this.findPage(1,model);
    }
    @PostMapping("/")
    public String SavePatient(@ModelAttribute("patient") Patients patient){
        patientsService.save(patient);
        return "redirect:/";
    }
    @GetMapping("/delete")
    public String deletePatient(@RequestParam("id") Long id){
        patientsService.deletePatientById(id);
        return "redirect:/";
    }
    @GetMapping("/editPatient")
    public String editPatient(@RequestParam("id") Long id , Model model){
        model.addAttribute("patientToEdite",patientsService.findById(id));
        return "editPatient";
    }
    @GetMapping("/page")
    public String findPage(@RequestParam("num") Integer num,Model model){
        Patients patient = new Patients();
        Pageable page = PageRequest.of(num-1,3);
        model.addAttribute("pages",patientsService.findPageble(page).getTotalPages());
        model.addAttribute("currentPage",num);
        model.addAttribute("patient",patient);
        model.addAttribute("listPatients",patientsService.findPageble(page));
        return "index";
    }
    @PostMapping("/search")
    public String search(@RequestParam("keyword") String keyword,Model model){
        Patients patient = new Patients();
        model.addAttribute("pages",1);
        model.addAttribute("currentPage",1);
        model.addAttribute("patient",patient);
        model.addAttribute("listPatients",patientsService.findByKeyword(keyword));
        return "index";
    }
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
