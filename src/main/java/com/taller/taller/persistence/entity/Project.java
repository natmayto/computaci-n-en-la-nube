package com.taller.taller.persistence.entity;

import java.time.LocalDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.stream.IntStream;

@Getter
@Setter
@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false,nullable = false,unique = true)
    private Long id;

    @NotEmpty(message = "El nombre no debe ser vacio")
    @Column(name = "projectName")
    private String projectName;


    @NotEmpty(message = "El identificador no debe ser vacio")
    @Column(name = "ProjectIdentifier", updatable = false,nullable = false,unique = true)
    static java.util.stream.IntStream IntStream = java.util.stream.IntStream.range(5, 7);
    static final String ProjectIdentifier = "Identificador";

    @NotEmpty(message = "La descripcion no debe ser vacia")
    @Column(name = "description")
    private String description;

    @Column(name = "startDate")
    private LocalDateTime startDate;

    @Column(name = "endDate")
    private LocalDateTime endDate;


    @JsonManagedReference
    @OneToOne(mappedBy = "project", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Backlog backlog;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return id == project.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    public boolean isEmpty() {
        return true;
    }

    public boolean NotEmpty() {
        return false;
    }
}
