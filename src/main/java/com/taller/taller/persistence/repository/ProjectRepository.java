package com.taller.taller.persistence.repository;

import com.taller.taller.persistence.entity.Project;
import com.taller.taller.persistence.entity.Status;
import com.taller.taller.service.dto.ProjectInDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {
    List<Project> findAllByTaskStatus(Status status);

    void markTaskAsFinished(Long id);

    Project createTask(ProjectInDTO projectInDTO);
}
