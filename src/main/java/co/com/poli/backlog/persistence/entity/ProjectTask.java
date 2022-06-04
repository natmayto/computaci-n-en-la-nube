package co.com.poli.backlog.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
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

    @Column(name = "summary")
    private String summary;

    @Column(name = "acceptanceCriterial")
    private String acceptanceCriterial;

    @Column(name = "status")
    private String status;

    @Column(name = "priority")
    private int priority;


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
