package co.com.poli.backlog.service;

import co.com.poli.backlog.mapper.ProjectDtoToProject;
import co.com.poli.backlog.mapper.ProjectTaskDtoToProjectTask;
import co.com.poli.backlog.persistence.entity.Project;
import co.com.poli.backlog.persistence.entity.ProjectTask;
import co.com.poli.backlog.persistence.repository.ProjectRepository;
import co.com.poli.backlog.service.dto.ProjectInDTO;
import co.com.poli.backlog.service.dto.ProjectTaskInDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectDtoToProject mapper;

    public Project createProject(ProjectInDTO projectInDTO){
        Project project = mapper.map(projectInDTO);
        projectRepository.save(project);
        return this.projectRepository.save(project);

    }


    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public Project save(Project project) {
        return projectRepository.save(project);
    }
}
