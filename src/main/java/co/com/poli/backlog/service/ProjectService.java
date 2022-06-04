package co.com.poli.backlog.service;

import co.com.poli.backlog.persistence.entity.Project;

import java.util.List;

public interface ProjectService {

    List<Project> findAll();

    Project save(Project project);

}
