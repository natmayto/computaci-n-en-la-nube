package com.taller.taller.service;

import com.taller.taller.exceptions.TodoExceptions;
import com.taller.taller.mapper.BacklogInDTOToBacklog;
import com.taller.taller.persistence.entity.Backlog;
import com.taller.taller.persistence.entity.Status;
import com.taller.taller.persistence.repository.BacklogRepository;
import com.taller.taller.service.dto.BacklogInDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.taller.taller.persistence.entity.Project;
import com.taller.taller.persistence.entity.ProjectTask;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BacklogService {
    private final BacklogRepository backlogRepository;
    private final BacklogInDTOToBacklog mapper;


    public Backlog createTask(BacklogInDTO backlogInDTO) {
        Backlog task = mapper.map(backlogInDTO);
        if (task.isEmpty()) {
            throw  new TodoExceptions("400 Bad Request", HttpStatus.BAD_REQUEST);
        }else{
            throw new TodoExceptions("201 Created", HttpStatus.CREATED);
        }
    }

    public List<Backlog> findAll() {
        return this.backlogRepository.findAll();
    }

    public List<Backlog> findAllByTaskStatus(Status status) {
        return this.backlogRepository.findAllByTaskStatus(status);
    }


    @Transactional
    public void updateTaskFinished(Long id) {
        Optional<Backlog> task = this.backlogRepository.findById(id);
        if (task.isEmpty()) {
            throw new TodoExceptions("Task not found", HttpStatus.NOT_FOUND);
        }
        this.backlogRepository.markTaskAsFinished(id);
    }

    public void deleteById(Long id) {
        Optional<Backlog> task = this.backlogRepository.findById(id);
        if (task.isEmpty()) {
            throw new TodoExceptions("Task not found", HttpStatus.NOT_FOUND);
        }
        this.backlogRepository.deleteById(id);
    }
}
