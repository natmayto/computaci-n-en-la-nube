package com.taller.taller.controller;

import com.taller.taller.persistence.entity.Project;
import com.taller.taller.persistence.entity.Status;
import com.taller.taller.service.ProjectService;
import com.taller.taller.service.dto.ProjectInDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.taller.taller.persistence.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;

    //Adicionar un nuevo proyecto
    @PostMapping("projects")
    public Project createTask(@RequestBody ProjectInDTO projectInDTO) {
        return this.projectService.createTask(projectInDTO);
    }

    //Ver todos los proyectos
    @GetMapping
    public List<Project> findAll() {
        return this.projectService.findAll();
    }

    @GetMapping("/status/{status}")
    public List<Project> findAllByTaskStatus(@PathVariable("status") Status Status) {
        return this.projectService.findAllByTaskStatus(Status);
    }

    @PatchMapping("/mark_as_finished/{id}")
    public ResponseEntity<Project> markTaskAsFinished(@PathVariable("id") Long id) {
        this.projectService.updateTaskFinished(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Project> delete(@PathVariable("id") Long id) {
        this.projectService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
