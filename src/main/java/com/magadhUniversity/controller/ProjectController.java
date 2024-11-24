package com.magadhUniversity.controller;
import com.magadhUniversity.model.Project;
import com.magadhUniversity.model.Student;
import com.magadhUniversity.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping("/add")
    public String addProjectForm(Model model) {
        model.addAttribute("project", new Project());
        return "add-project";
    }

    @PostMapping("/add")
    public String addProjectSubmit(@ModelAttribute Project project) {
        projectService.saveProject(project);
        return "redirect:/projects/add";
    }

    @GetMapping("/pending")
    public String viewPendingProjects(Model model) {
        model.addAttribute("projects", projectService.getProjectsByStatus("Pending"));
        return "pending-projects";
    }

    @GetMapping("/approved")
    public String viewApprovedProjects(Model model) {
        model.addAttribute("projects", projectService.getProjectsByStatus("Approved"));
        return "approved-projects";
    }
    @GetMapping("/approvedf")
    public String viewApprovedProjectss(Model model) {
        model.addAttribute("projects", projectService.getProjectsByStatus("Approved"));
        return "approved-projects";
    }

    @PostMapping("/approve/{id}")
    public String approveProject(@PathVariable Long id, @RequestParam Long employeeId) {
        projectService.approveProject(id, employeeId);
        return "redirect:/projects/pending";
    }
}
