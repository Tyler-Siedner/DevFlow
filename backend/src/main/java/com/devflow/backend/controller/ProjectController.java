package com.devflow.backend.controller;

import com.devflow.backend.model.Project;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @GetMapping
    public List<Project> getProjects() {

        Project project1 = new Project(
                1L,
                "DevFlow",
                "A project management application"
        );

        Project project2 = new Project(
                2L,
                "Portfolio Website",
                "My personal software development portfolio"
        );

        return List.of(project1, project2);
    }

    @GetMapping("/{id}")
    public Project getProjectById(@PathVariable Long id) {

        if (id == 1) {
            return new Project(
                    1L,
                    "DevFlow",
                    "A project management application"
            );
        }

        if (id == 2) {
            return new Project(
                    2L,
                    "Portfolio Website",
                    "My personal software development portfolio"
            );
        }

        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Project not found"
        );
    }
}