package com.taller.taller.service.dto;


import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Data

public class ProjectInDTO {
    private Long id;
    private String projectName;
    private String ProjectIdentifier;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
