package com.amigoscode.securityfirstcontact.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private static final List<Student> STUDENTS = Arrays.asList(

            new Student(1L, "Andrzej"),
            new Student(2L, "Janusz"),
            new Student(3L, "Brajanusz")

    );

    @GetMapping("/{studentId}")
    public Student getStudent(@PathVariable Long studentId) {
        return STUDENTS.stream()
                .filter(student -> student.getStudentId().equals(studentId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Student not found"));
    }

}
