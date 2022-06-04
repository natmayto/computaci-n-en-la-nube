package co.com.poli.backlog.controller;

import co.com.poli.backlog.persistence.entity.Project;
import co.com.poli.backlog.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping
    public List<Project> findAll() {
        return projectService.findAll();
    }

    @PostMapping
    public Project save(@RequestBody Project project) {
        return projectService.save(project);
    }

}
