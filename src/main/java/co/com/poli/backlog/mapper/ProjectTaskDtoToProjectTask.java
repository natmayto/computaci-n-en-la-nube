package co.com.poli.backlog.mapper;

import co.com.poli.backlog.persistence.entity.Backlog;
import co.com.poli.backlog.persistence.entity.ProjectTask;
import co.com.poli.backlog.persistence.entity.Status;
import co.com.poli.backlog.service.dto.ProjectTaskInDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ProjectTaskDtoToProjectTask implements IMapper<ProjectTaskInDTO, ProjectTask>{

    @Override
    public ProjectTask map(ProjectTaskInDTO in) {
        ProjectTask projectTask = new ProjectTask();
        projectTask.setName(in.getName());
        projectTask.setSummary(in.getSummary());
        projectTask.setAcceptanceCriterial(in.getAcceptanceCriterial());
        projectTask.setStatus(Status.In_progress);
        projectTask.setPriority(in.getPriority());
        projectTask.setHours(in.getHours());
        projectTask.setStartDate(LocalDateTime.now());
        projectTask.setEndDate(in.getEndDate());
        projectTask.setProjectIdentifier(in.getProjectIdentifier());
        projectTask.setBacklog(in.getBacklog());
        return projectTask;
    }
}
