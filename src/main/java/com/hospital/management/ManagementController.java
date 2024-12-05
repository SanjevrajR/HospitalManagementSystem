package com.hospital.management;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/management")
public class ManagementController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @GetMapping
    public String viewManagement(Model model) {
        model.addAttribute("employees", employeeRepository.findAll());
        model.addAttribute("doctors", doctorRepository.findAll());
        return "management";
    }
}

