package co.com.poli.backlog.service;

import co.com.poli.backlog.persistence.entity.Project;
import co.com.poli.backlog.persistence.entity.ProjectTask;
import co.com.poli.backlog.service.dto.ProjectInDTO;
import co.com.poli.backlog.service.dto.ProjectTaskInDTO;

import java.util.List;

public interface ProjectService {

    Project createProject(ProjectInDTO projectInDTO);

    List<Project> findAll();

    Project save(Project project);

}
