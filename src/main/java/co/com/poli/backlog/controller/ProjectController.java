package co.com.poli.backlog.controller;

import co.com.poli.backlog.helpers.ErrorMessage;
import co.com.poli.backlog.helpers.Response;
import co.com.poli.backlog.helpers.ResponseBuild;
import co.com.poli.backlog.persistence.entity.Project;
import co.com.poli.backlog.service.ProjectService;
import co.com.poli.backlog.service.dto.ProjectInDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/project")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;
    private final ResponseBuild builder;

    @GetMapping
    public Response findAll() {
        return builder.success(projectService.findAll());
    }

    @PostMapping
    public Response createTask(@Valid  @RequestBody ProjectInDTO projectInDTO, BindingResult result){

        if(result.hasErrors()){
            return builder.failed(formatMessage(result));
        }
        projectService.createProject(projectInDTO);
        return builder.success(projectInDTO);

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

}
