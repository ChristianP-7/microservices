package com.microservice.student.Persistence;

import com.microservice.student.Entities.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

    //Por alguna razón usando esta query la app no levantó
//    @Query("SELECT s FROM Stundent s WHERE s.courseId = :idCourse")
//    List<Student> findAllStudents(Long idCourse);

    List<Student> findAllByCourseId(Long courseId);
}
