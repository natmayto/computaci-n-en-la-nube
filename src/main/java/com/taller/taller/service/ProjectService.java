package com.taller.taller.service;
import com.taller.taller.exceptions.TodoExceptions;
import com.taller.taller.mapper.ProjectInDTOToProject;
import com.taller.taller.persistence.entity.Project;
import com.taller.taller.persistence.entity.ProjectTask;
import com.taller.taller.persistence.entity.Status;
import com.taller.taller.persistence.repository.ProjectRepository;
import com.taller.taller.service.dto.BacklogInDTO;
import com.taller.taller.service.dto.ProjectInDTO;
import com.taller.taller.service.dto.ProjectTaskInDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.taller.taller.persistence.entity.Backlog;

import javax.validation.constraints.NotEmpty;




import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final ProjectInDTOToProject mapper;
    private ProjectService projectService;

    public Project createTask(ProjectInDTO projectInDTO) throws TodoExceptions {
        Project task = mapper.map(projectInDTO);

        if (task.isEmpty()) {
            throw new TodoExceptions("400 Bad Request", HttpStatus.BAD_REQUEST);
        } else {
            throw new TodoExceptions("201 Created", HttpStatus.CREATED);
        }

    }


    public List<Project> findAll() {
        return this.projectRepository.findAll();
    }

    public List<Project> findAllByTaskStatus(Status status) {
        return this.projectRepository.findAllByTaskStatus(status);
    }

    @Transactional
    public void updateTaskFinished(Long id) {
        Optional<Project> task = this.projectRepository.findById(id);
        if (task.isEmpty()) {
            throw new TodoExceptions("Task not found", HttpStatus.NOT_FOUND);
        }
        this.projectRepository.markTaskAsFinished(id);
    }

    public void deleteById(Long id) {
        Optional<Project> task = this.projectRepository.findById(id);
        if (task.isEmpty()) {
            throw new TodoExceptions("Task not found", HttpStatus.NOT_FOUND);
        }
        this.projectRepository.deleteById(id);
    }
}
