package co.com.poli.backlog.service.dto;

import co.com.poli.backlog.persistence.entity.Backlog;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProjectInDTO {

    private String name;
    private String projectIdentifier;
    private String description;
    private LocalDateTime endDate;
    private Backlog backlog;
}
