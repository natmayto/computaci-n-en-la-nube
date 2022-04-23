package co.com.poli.courses.service;

import co.com.poli.courses.persistence.entity.Instructor;

import java.util.List;

public interface InstructorService {

    List<Instructor> findAll();

    Instructor save(Instructor instructor);

}
