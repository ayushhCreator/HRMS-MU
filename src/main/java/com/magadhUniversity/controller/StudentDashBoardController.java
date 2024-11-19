package com.magadhUniversity.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/student")
public class StudentDashBoardController
{

    @GetMapping("/timetable")
    public String timetable() {
        // Redirect to general profile management
        return "timetable"; // timetable.html template
    }
    @GetMapping("/examination")
    public String profile() {
        // Redirect to general profile management
        return "examination"; // examination.html template
    }

    @GetMapping("/stupassreset")
    public String resetpassword() {
        // Redirect to general profile management
        return "password"; // password.html template
    }

    @GetMapping("/logout")
    public String logout() {
        // Handle logout logic (e.g., clearing session) here if necessary
        return "redirect:/login"; // Redirect to login page
    }
}
