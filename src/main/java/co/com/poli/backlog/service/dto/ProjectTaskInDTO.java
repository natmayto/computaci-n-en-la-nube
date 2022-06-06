package co.com.poli.backlog.service.dto;

import co.com.poli.backlog.persistence.entity.Backlog;
import co.com.poli.backlog.persistence.entity.Status;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Data
public class ProjectTaskInDTO {


    private String name;
    private String summary;
    private String acceptanceCriterial;
    private int priority;
    private double hours;
    private LocalDateTime endDate;
    private String projectIdentifier;
    private Backlog backlog;

}
