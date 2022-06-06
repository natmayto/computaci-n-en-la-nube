package co.com.poli.backlog.controller;


import co.com.poli.backlog.helpers.ErrorMessage;
import co.com.poli.backlog.helpers.Response;
import co.com.poli.backlog.helpers.ResponseBuild;
import co.com.poli.backlog.persistence.entity.Backlog;
import co.com.poli.backlog.persistence.entity.ProjectTask;
import co.com.poli.backlog.service.BacklogService;
import co.com.poli.backlog.service.ProjectTaskService;
import co.com.poli.backlog.service.dto.ProjectInDTO;
import co.com.poli.backlog.service.dto.ProjectTaskInDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/projecttasks")
@RequiredArgsConstructor
public class ProjectTaskController {


    private final ProjectTaskService projectTaskService;
    private final ResponseBuild builder;

    @GetMapping
    public List<ProjectTask> findAll() {
        return projectTaskService.findAll();
    }


    @PostMapping
    public Response createTask(@Valid  @RequestBody ProjectTaskInDTO projectTaskInDTO, BindingResult result){

        if(result.hasErrors()){
            return builder.failed(formatMessage(result));
        }
        projectTaskService.createProjectTask(projectTaskInDTO);
        return builder.success(projectTaskInDTO);

    }

    private String formatMessage(BindingResult result) {
        List<Map<String, String>> errors = result.getFieldErrors().stream()
                .map(error -> {
                    Map<String, String> err = new HashMap<>();
                    err.put(error.getField(), error.getDefaultMessage());
                    return err;
                }).collect(Collectors.toList());
        ErrorMessage errorMessage = ErrorMessage.builder()
                .error(errors).build();
        ObjectMapper mapper = new ObjectMapper();
        String json = "{\n" +
                "  \"code\": 400,\n" +
                "  \"data\": \n" +
                "    {\n" +
                "      \"price\": \"Algo salio mal\"\n" +
                "    }" +
                "}";
        try {
            json = mapper.writeValueAsString(errorMessage);
        } catch (JsonProcessingException ex) {
            ex.printStackTrace();
        }
        return json;
    }

    @GetMapping("/{id}")
    public Response findById(@PathVariable("id") Long id) {
        return builder.success(projectTaskService.findById(id));
    }


}
