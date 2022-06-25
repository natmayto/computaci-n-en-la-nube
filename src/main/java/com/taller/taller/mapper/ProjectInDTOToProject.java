package com.taller.taller.mapper;

import com.taller.taller.persistence.entity.Project;
import com.taller.taller.service.dto.ProjectInDTO;
import org.springframework.stereotype.Component;

@Component
public class ProjectInDTOToProject implements IMapper<ProjectInDTO, Project> {
    @Override
    public Project map(ProjectInDTO in) {
        Project project = new Project();
        project.setId(in.getId());
        project.setProjectName(in.getProjectName());
        project.setDescription(in.getDescription());
        project.setStartDate(in.getStartDate());
        project.setEndDate(in.getEndDate());
        return project;
    }
}
