package com.taller.taller.persistence.repository;

import com.taller.taller.persistence.entity.ProjectTask;
import com.taller.taller.persistence.entity.Status;
import com.taller.taller.service.dto.ProjectTaskInDTO;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectTaskRepository extends JpaRepository<ProjectTask,Long> {

    List<ProjectTask> findAllByTaskStatus(Status status, StartDate startDate, EndDate endDate);

    List<ProjectTask> findAll(ProjectTaskInDTO projectTaskInDTO);
    void markTaskAsFinished(Long id);


    List<ProjectTask> findAll(StartDate startDate, EndDate endDate);



    List<ProjectTask> deleteById(Long id, Status status);
}
