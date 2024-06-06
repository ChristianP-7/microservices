package com.microservice.student.Service;

import com.microservice.student.Entities.Student;

import java.util.List;

public interface IStudentService {

    List<Student> findAll();

    Student findById(Long id);

    void save(Student student);

    List<Student> findByCourseId(Long courseId);
}
