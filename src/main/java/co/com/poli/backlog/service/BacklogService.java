package co.com.poli.backlog.service;

import co.com.poli.backlog.persistence.entity.Backlog;
import co.com.poli.backlog.persistence.entity.Project;
import co.com.poli.backlog.persistence.entity.ProjectTask;
import co.com.poli.backlog.persistence.repository.BacklogRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BacklogService {



    List<Backlog> findAll();

    Backlog findById(Long id);



    Backlog save(Backlog backlog);









}
