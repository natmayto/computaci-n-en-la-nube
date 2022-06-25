package com.taller.taller.controller;

import com.taller.taller.persistence.entity.Backlog;
import com.taller.taller.persistence.entity.Status;
import com.taller.taller.persistence.repository.BacklogRepository;
import com.taller.taller.service.BacklogService;
import com.taller.taller.service.dto.BacklogInDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@RestController
@RequestMapping("/backlogs")
@RequiredArgsConstructor
public class BacklogController {
    private final BacklogService backlogService;

    //Adicionar un nuevo backlog
    @PostMapping("backlogs")
    public Backlog createTask(@RequestBody BacklogInDTO backlogInDTO) {
        return this.backlogService.createTask(backlogInDTO);
    }

    @GetMapping
    public List<Backlog> findAll() {
        return this.backlogService.findAll();
    }

    @GetMapping("/status/{status}")
    public List<Backlog> findAllByTaskStatus(@PathVariable("status") Status Status) {
        return this.backlogService.findAllByTaskStatus(Status);
    }

    @PatchMapping("/mark_as_finished/{id}")
    public ResponseEntity<Backlog> markTaskAsFinished(@PathVariable("id") Long id) {
        this.backlogService.updateTaskFinished(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Backlog> delete(@PathVariable("id") Long id) {
        this.backlogService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
