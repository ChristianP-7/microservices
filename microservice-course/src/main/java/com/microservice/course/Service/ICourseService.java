package com.microservice.course.Service;

import com.microservice.course.Entities.Course;
import com.microservice.course.Http.Response.StudentsByCourseResponse;

import java.util.List;

public interface ICourseService {

    List<Course> findAll();

    Course findById(Long id);

    void save(Course course);

    StudentsByCourseResponse findStudentsByCourseId(Long courseId);

}
