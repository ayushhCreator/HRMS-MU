package com.magadhUniversity.service;
import com.magadhUniversity.model.Project;
import com.magadhUniversity.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public List<Project> getProjectsByStatus(String status) {
        return projectRepository.findByStatus(status);
    }

    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }

    public Project approveProject(Long id, Long employeeId) {
        Project project = projectRepository.findById(id).orElseThrow(() -> new RuntimeException("Project not found"));
        project.setStatus("Approved");
        project.setApprovedBy(employeeId);
        return projectRepository.save(project);
    }
}