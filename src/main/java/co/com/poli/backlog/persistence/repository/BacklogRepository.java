package co.com.poli.backlog.persistence.repository;

import co.com.poli.backlog.persistence.entity.Backlog;
import co.com.poli.backlog.persistence.entity.Project;
import co.com.poli.backlog.persistence.entity.ProjectTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BacklogRepository extends JpaRepository<Backlog,Long> {


}
