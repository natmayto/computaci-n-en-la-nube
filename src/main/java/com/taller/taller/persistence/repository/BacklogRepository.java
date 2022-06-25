package com.taller.taller.persistence.repository;
import com.taller.taller.service.BacklogService;
import com.taller.taller.persistence.entity.Backlog;
import com.taller.taller.persistence.entity.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BacklogRepository extends JpaRepository<Backlog,Long> {
    List<Backlog> findAllByTaskStatus(Status status);

    void markTaskAsFinished(Long id);
}
