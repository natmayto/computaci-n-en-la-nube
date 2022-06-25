package co.com.poli.backlog.service;

import co.com.poli.backlog.persistence.entity.Project;
import co.com.poli.backlog.persistence.entity.ProjectTask;
import co.com.poli.backlog.persistence.entity.Status;
import co.com.poli.backlog.service.dto.ProjectTaskInDTO;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProjectTaskService {

    List<ProjectTask> findAll();

    ProjectTask save(ProjectTask projectTask);

    ProjectTask createProjectTask(ProjectTaskInDTO projectTaskInDTO);

    ProjectTask findById(Long id);

    ProjectTask remove(Long id);

    default ProjectTask find(Enum Status) {
        return find();
    }

    ProjectTask find();
}


