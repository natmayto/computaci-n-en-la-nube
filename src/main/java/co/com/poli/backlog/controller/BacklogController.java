package co.com.poli.backlog.controller;

import co.com.poli.backlog.persistence.entity.Backlog;
import co.com.poli.backlog.service.BacklogService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/backlogs")
@RequiredArgsConstructor
public class BacklogController {

    private final BacklogService backlogService;

    @GetMapping
    public List<Backlog> findAll() {
        return backlogService.findAll();
    }

    @PostMapping
    public Backlog save(@Valid @RequestBody Backlog backlog, BindingResult result) {
        if(result.hasErrors()){
            return new Backlog();
        }
        return backlogService.save(backlog);
    }
}
