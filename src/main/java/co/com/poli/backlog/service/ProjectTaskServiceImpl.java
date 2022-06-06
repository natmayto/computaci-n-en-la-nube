package co.com.poli.backlog.service;


import co.com.poli.backlog.mapper.ProjectTaskDtoToProjectTask;
import co.com.poli.backlog.persistence.entity.ProjectTask;
import co.com.poli.backlog.persistence.repository.ProjectTaskRepository;
import co.com.poli.backlog.service.dto.ProjectTaskInDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectTaskServiceImpl implements ProjectTaskService{

    private final ProjectTaskRepository projectTaskRepository;
    private final ProjectTaskDtoToProjectTask mapper;

    public ProjectTask createProjectTask(ProjectTaskInDTO projectTaskInDTO){
        ProjectTask projectTask = mapper.map(projectTaskInDTO);
        projectTaskRepository.save(projectTask);
        return this.projectTaskRepository.save(projectTask);

    }


    @Override
    public List<ProjectTask> findAll() {
        return projectTaskRepository.findAll();
    }

    @Override
    public ProjectTask save(ProjectTask projectTask) {
        return projectTaskRepository.save(projectTask);
    }

    @Override
    @Transactional(readOnly = true)
    public ProjectTask findById(Long id) {
        return projectTaskRepository.findById(id).orElse(null);
    }



}
