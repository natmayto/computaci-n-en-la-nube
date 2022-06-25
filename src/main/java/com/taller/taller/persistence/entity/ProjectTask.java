package com.taller.taller.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.stream.IntStream;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;


@RequiredArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "projecttasks")
public class ProjectTask {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false,nullable = false,unique = true)
    @NotEmpty(message = "El id no debe ser vacio")
    private Long id;

    @Column(name = "name")
    @NotEmpty(message = "El name no debe ser vacio")
    private String name;

    @Column(name = "summary")
    @NotEmpty(message = "El summary no debe ser vacio")
    private String summary;

    @Column(name = "acceptanceCriterial")
    private String acceptanceCriteria;

    @Column(name = "status")
    private Status status;

    @Column(name = "priority")
    static IntStream IntStream = java.util.stream.IntStream.range(1, 5);
    private int priority;

    @Column(name = "hours")
    static IntStream IntStream2 = java.util.stream.IntStream.range(1, 8);
    private double hours;

    @Column(name = "startDate")
    private LocalDateTime startDate;

    @Column(name = "endDate")
    private LocalDateTime endDate;

    @Column(name = "ProjectIdentifier")
    static final String ProjectIdentifier = "";


    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "backlog_id")
    private Backlog backlog;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectTask that = (ProjectTask) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public boolean isEmpty() {
        return true;
    }
}
