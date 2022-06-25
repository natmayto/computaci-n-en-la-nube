package com.taller.taller.service.dto;

import com.taller.taller.persistence.entity.Status;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data

public class ProjectTaskInDTO {
    private Long id;
    private String name;
    private String summary;
    private String acceptanceCriteria;
    private Status status;
    private int priority;
    private double hours;
    static final String ProjectIdentifier = "Identification";

}
