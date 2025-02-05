package com.microservice.course.Client;

import com.microservice.course.Dto.StudentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "msvc-student", url = "localhost:8090")
public interface StudentClient {

    @GetMapping("/api/student/search-by-course/{courseId}")
    List<StudentDTO> findAllStudentsByCourse(@PathVariable Long courseId);
}
