package co.com.poli.backlog.service;

import co.com.poli.backlog.persistence.entity.Backlog;
import co.com.poli.backlog.persistence.repository.BacklogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
