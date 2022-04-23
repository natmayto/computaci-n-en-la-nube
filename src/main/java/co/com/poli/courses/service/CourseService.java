package co.com.poli.courses.service;

import co.com.poli.courses.persistence.entity.Course;

import java.util.List;

public interface CourseService {

    List<Course> findAll();

    Course save(Course course);
}
