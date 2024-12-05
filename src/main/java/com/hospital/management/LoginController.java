package com.hospital.management;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("/login")
public class LoginController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DoctorRepository doctorRepository;
    
    @GetMapping("/login1")
    public String login1() {
    	return "login";
    }
    
    @PostMapping("/login2")
    public String login(@RequestParam String username, @RequestParam String password, @RequestParam String role) {
        if (role.equals("employee") && employeeRepository.findByUsernameAndPassword(username, password) != null) {
            return "redirect:/home";
        } else if (role.equals("doctor") && doctorRepository.findByUsernameAndPassword(username, password) != null) {
            return "redirect:/home";
        }
        return "redirect:/login?error=true";
    }
}

