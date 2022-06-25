package com.taller.taller.controller;
import com.taller.taller.persistence.entity.ProjectTask;
import com.taller.taller.persistence.entity.Status;
import com.taller.taller.persistence.repository.EndDate;
import com.taller.taller.persistence.repository.StartDate;
import com.taller.taller.service.ProjectTaskService;
import com.taller.taller.service.dto.ProjectTaskInDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/projecttasks")
@RequiredArgsConstructor
public class ProjectTaskController {
    private final ProjectTaskService projectTaskService;
    private ProjectTaskController projectTaskRepository;
    private StartDate startDate ;
    private EndDate endDate;

    //Adicionar una nueva tarea
    @PostMapping("tasks")
    public ProjectTask createTask(@RequestBody ProjectTaskInDTO projectTaskInDTO) {
        return this.projectTaskService.createTask(projectTaskInDTO);
    }

    //ver todas las tareas del proyecto si no existe, devuelve un 404 Not Found
    @GetMapping("/task/project/{projectIdentifier}")
    public List<ProjectTask> findAll(@PathVariable ProjectTaskInDTO projectTaskInDTO, @PathVariable String projectIdentifier) {
        return this.projectTaskService.findAll(projectTaskInDTO);
    }

    //Total de horas del proyecto
    @GetMapping("/task/project/{projectIdentifier}")
    private List<ProjectTask> findAll(@PathVariable StartDate startDate, EndDate endDate, @PathVariable String projectIdentifier) {
        return this.projectTaskService.findAll(startDate,endDate);
    }


    //Total de horas de proyecto por status
    @GetMapping("/task/project/{projectIdentifier}/{status")
    public List<ProjectTask> findAllByTaskStatus(@PathVariable("status") Status status, StartDate startDate, EndDate endDate) {
        return this.projectTaskService.findAllByTaskStatus(status, startDate, endDate);
    }



    @PatchMapping("/mark_as_finished/{id}")
    public ResponseEntity<ProjectTask> markTaskAsFinished(@PathVariable("id") Long id) {
        this.projectTaskService.updateTaskFinished(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/task/{idtask}/{projectIdentifier}")
    public void deleteById(@PathVariable("id") Long id, Status status) {
        this.projectTaskService.deleteById(id, status);

    }
}
