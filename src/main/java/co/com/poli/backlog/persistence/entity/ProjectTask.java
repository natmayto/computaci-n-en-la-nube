package co.com.poli.backlog.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jdk.jshell.Snippet;
import lombok.*;


import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "projecttasks")
public class ProjectTask {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false,nullable = false,unique = true)
    private Long id;


    @NotEmpty(message = "El nombre no debe ser vacio")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "El nombre no debe ser vacio")
    @Column(name = "summary")
    private String summary;

    @NotEmpty(message = "El nombre no debe ser vacio")
    @Column(name = "acceptanceCriterial")
    private String acceptanceCriterial;

    @Column(name = "status")
    private Status status;

    @Min(1)
    @Max(5)
    @Column(name = "priority")
    private int priority;

    @Min(1)
    @Max(8)
    @Column(name = "hours")
    private double hours;

    @Column(name = "startDate")
    private LocalDateTime startDate;

    @Column(name = "endDate")
    private LocalDateTime endDate;

    @Column(name = "projectIdentifier")
    private String projectIdentifier;


    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "backlog_id")
    private Backlog backlog;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProjectTask)) return false;
        ProjectTask that = (ProjectTask) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
