package co.com.poli.backlog.service;

import co.com.poli.backlog.persistence.entity.Backlog;
import co.com.poli.backlog.persistence.entity.Project;
import co.com.poli.backlog.persistence.entity.ProjectTask;
import co.com.poli.backlog.persistence.repository.BacklogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
@RequiredArgsConstructor
public class BacklogServiceImpl implements BacklogService {

    private final BacklogRepository backlogRepository;



    @Override
    public List<Backlog> findAll() {
        return backlogRepository.findAll();
    }

    @Override
    public Backlog save(Backlog backlog) {
        return backlogRepository.save(backlog);
    }

    @Override
    @Transactional(readOnly = true)
    public Backlog findById(Long id) {
        return backlogRepository.findById(id).orElse(null);
    }







}
