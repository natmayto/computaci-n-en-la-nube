package co.com.poli.backlog.service;

import co.com.poli.backlog.persistence.entity.Project;
import co.com.poli.backlog.persistence.entity.ProjectTask;

import java.util.List;

public interface ProjectTaskService {

    List<ProjectTask> findAll();

    ProjectTask save(ProjectTask projectTask);


}
