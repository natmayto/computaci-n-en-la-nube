package co.com.poli.backlog.controller;


import co.com.poli.backlog.persistence.entity.Backlog;
import co.com.poli.backlog.persistence.entity.ProjectTask;
import co.com.poli.backlog.service.BacklogService;
import co.com.poli.backlog.service.ProjectTaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/projecttasks")
@RequiredArgsConstructor
public class ProjectTaskController {


    private final ProjectTaskService projectTaskService;

    @GetMapping
    public List<ProjectTask> findAll() {
        return projectTaskService.findAll();
    }

    @PostMapping
    public ProjectTask save(@Valid @RequestBody ProjectTask projectTask, BindingResult bindingResult) {
        return projectTaskService.save(projectTask);
    }

}
