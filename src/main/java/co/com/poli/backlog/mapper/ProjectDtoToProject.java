package co.com.poli.backlog.mapper;

import co.com.poli.backlog.persistence.entity.Project;
import co.com.poli.backlog.service.dto.ProjectInDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ProjectDtoToProject implements IMapper<ProjectInDTO, Project>{

    @Override
    public Project map(ProjectInDTO in) {
        Project project = new Project();
        project.setName(in.getName());
        project.setProjectIdentifier(in.getProjectIdentifier());
        project.setDescription(in.getDescription());
        project.setCreatedDate(LocalDateTime.now());
        project.setEndDate(in.getEndDate());
        project.setBacklog(in.getBacklog());
        
        return project;
    }
}
