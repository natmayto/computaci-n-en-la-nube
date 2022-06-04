package co.com.poli.backlog.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

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
    private String name;

    @NotEmpty(message = "El identificador no debe ser vacio")
    @Column(name = "projectIdentifier")
    private String projectIdentifier;

    @NotEmpty(message = "La descripcion no debe ser vacia")
    @Column(name = "description")
    private String description;

    @Column(name = "createdDate")
    private LocalDateTime createdDate;

    @Column(name = "endDate")
    private LocalDateTime endDate;


    @JsonManagedReference
    @OneToOne(mappedBy = "project", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Backlog backlog;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project that = (Project) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
