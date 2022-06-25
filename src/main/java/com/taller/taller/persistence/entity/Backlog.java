package com.taller.taller.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import java.util.Objects;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import org.apache.commons.lang3.Validate;
@Getter
@Setter
@Entity
@Table(name = "backlogs")
public class Backlog {
    private static final Validate VALIDATOR = new Validate();


    @Id
    @GeneratedValue
    @Column(name="id", updatable = false,nullable = false,unique = true)
    private Long id;

    @NotEmpty(message = "No puede estar vacio")
    @Column(name="ProjectIdentifier")
    private String ProjectIdentifier;

    @JsonBackReference
    @OneToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "project_id")
    private Project project;

    @JsonBackReference
    @OneToMany(mappedBy = "backlog")
    private List<ProjectTask> projectTask ;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Backlog backlog = (Backlog) o;
        return id == backlog.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    public boolean isEmpty() {
        return false;
    }


}
