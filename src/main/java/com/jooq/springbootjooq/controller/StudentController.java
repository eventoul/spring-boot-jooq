package com.jooq.springbootjooq.controller;

import com.jooq.springbootjooq.generated.tables.pojos.Student;
import com.jooq.springbootjooq.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/list")
    public List<Student> list() {

        return studentService.selectAll();
    }

    @GetMapping("/detail/{studentId}")
    public List<Student> detail(@PathVariable int studentId) {

        return studentService.selectById(studentId);
    }
}
