package co.com.poli.backlog.service;

import co.com.poli.backlog.persistence.entity.Backlog;

import java.util.List;

public interface BacklogService {

    List<Backlog> findAll();

    Backlog save(Backlog backlog);
}
