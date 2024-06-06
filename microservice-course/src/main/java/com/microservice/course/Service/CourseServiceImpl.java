package com.microservice.course.Service;

import com.microservice.course.Client.StudentClient;
import com.microservice.course.Dto.StudentDTO;
import com.microservice.course.Entities.Course;
import com.microservice.course.Http.Response.StudentsByCourseResponse;
import com.microservice.course.Persistence.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService{

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentClient studentClient;

    @Override
    public List<Course> findAll() {
        return (List<Course>) courseRepository.findAll();
    }

    @Override
    public Course findById(Long id) {
        return courseRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Course course) {
        courseRepository.save(course);
    }

    @Override
    public StudentsByCourseResponse findStudentsByCourseId(Long courseId) {

        //Consultar el curso
        Course course = courseRepository.findById(courseId).orElse(new Course());

        //Obtenemos los estudiantes
        List<StudentDTO> studentDTOList = studentClient.findAllStudentsByCourse(courseId);

        //Retornamos la respuesta
        return StudentsByCourseResponse.builder()
                .courseName(course.getName())
                .teacher(course.getTeacher())
                .studentDTOList(studentDTOList)
                .build();
    }
}
