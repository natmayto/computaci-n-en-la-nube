package co.com.poli.backlog.controller;

import co.com.poli.backlog.helpers.ErrorMessage;
import co.com.poli.backlog.helpers.Response;
import co.com.poli.backlog.helpers.ResponseBuild;
import co.com.poli.backlog.persistence.entity.Backlog;
import co.com.poli.backlog.persistence.entity.ProjectTask;
import co.com.poli.backlog.service.BacklogService;
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
@RequestMapping("/backlogs")
@RequiredArgsConstructor
public class BacklogController {

    private final BacklogService backlogService;
    private final ResponseBuild builder;

    @GetMapping
    public Response findAll() {
        return builder.success(backlogService.findAll());
    }



    @PostMapping
    public Response save(@Valid @RequestBody Backlog backlog, BindingResult result) {

        if(result.hasErrors()){
            return builder.failed(formatMessage(result));
        }
        backlogService.save(backlog);
        return builder.success(backlog);
    }

    @GetMapping("/{id}")
    public Response findById(@PathVariable("id") Long id) {
        return builder.success(backlogService.findById(id));
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
