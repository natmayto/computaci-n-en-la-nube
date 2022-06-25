package com.taller.taller.mapper;
import com.taller.taller.persistence.entity.ProjectTask;
import com.taller.taller.persistence.entity.Status;
import com.taller.taller.service.dto.ProjectTaskInDTO;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
@Component
public class ProjectTaskInDTOToProjectTask implements IMapper<ProjectTaskInDTO, ProjectTask> {
    @Override
    public ProjectTask map(ProjectTaskInDTO in) {
        ProjectTask projectTask = new ProjectTask();
        projectTask.setId(in.getId());
        projectTask.setName(in.getName());
        projectTask.setSummary(in.getSummary());
        projectTask.setAcceptanceCriteria(in.getAcceptanceCriteria());
        projectTask.setStatus(Status.IN_PROGRESS);
        projectTask.setPriority(in.getPriority());
        projectTask.setHours(in.getHours());
        projectTask.setStartDate(LocalDateTime.now());
        projectTask.setEndDate(LocalDateTime.now());
        return projectTask;
    }
}
