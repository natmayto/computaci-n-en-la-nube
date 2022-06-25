package com.taller.taller.service;
import com.taller.taller.exceptions.TodoExceptions;
import com.taller.taller.mapper.ProjectTaskInDTOToProjectTask;
import com.taller.taller.persistence.entity.ProjectTask;
import com.taller.taller.persistence.entity.Status;
import com.taller.taller.persistence.repository.EndDate;
import com.taller.taller.persistence.repository.ProjectTaskRepository;
import com.taller.taller.persistence.repository.StartDate;
import com.taller.taller.service.dto.ProjectTaskInDTO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static com.taller.taller.persistence.entity.Status.DELETED;
import static java.lang.Enum.valueOf;

@Service
@RequiredArgsConstructor
public class ProjectTaskService {
    private final ProjectTaskRepository projectTaskRepository;
    private final ProjectTaskInDTOToProjectTask mapper;
    private ProjectTaskService projectTaskService;



    public ProjectTask createTask(ProjectTaskInDTO projectTaskInDTO) {
        ProjectTask task = mapper.map(projectTaskInDTO);
        if (task.isEmpty()) {
            throw new TodoExceptions("400 Bad Request", HttpStatus.BAD_REQUEST);
        } else
        throw new TodoExceptions("201 Created", HttpStatus.CREATED);
    }


    public List<ProjectTask> findAll(ProjectTaskInDTO projectTaskInDTO) {
        ProjectTask task = mapper.map(projectTaskInDTO);
        if (task.isEmpty()) {
            throw new TodoExceptions("404 Not Found", HttpStatus.NOT_FOUND);
        }else {
            return this.projectTaskRepository.findAll(projectTaskInDTO);
        }
    }

    public List<ProjectTask> findAllByTaskStatus(Status status, StartDate startDate, EndDate endDate) {
        return this.projectTaskRepository.findAllByTaskStatus(status, startDate, endDate);
    }

    public List<ProjectTask> findAll(StartDate startDate, EndDate endDate) {
        return this.projectTaskRepository.findAll(startDate, endDate);
    }

    @Transactional
    public void updateTaskFinished(Long id) {
        Optional<ProjectTask> task = this.projectTaskRepository.findById(id);
        if (task.isEmpty()) {
            throw new TodoExceptions("Task not found", HttpStatus.NOT_FOUND);
        }
        this.projectTaskRepository.markTaskAsFinished(id);
    }

    public void deleteById(Long id, Status status) {
        Optional<ProjectTask> task = this.projectTaskRepository.findById(id);
        if(!(task.isEmpty() ||  task == null)){
            this.projectTaskRepository.deleteById(id);
        }

        task = this.projectTaskRepository.findById(id);
        if (task.isEmpty()){
            throw new TodoExceptions("DELETED", HttpStatus.NOT_FOUND);
        }

    }
}

