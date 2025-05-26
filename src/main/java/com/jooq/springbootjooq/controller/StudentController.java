package com.jooq.springbootjooq.controller;

import com.jooq.springbootjooq.generated.tables.pojos.Student;
import com.jooq.springbootjooq.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/list")
    public List<Student> getStudents() {

        return studentService.selectAll();
    }

    @GetMapping("/detail/{studentId}")
    public List<Student> getStudentById(@PathVariable int studentId) {

        return studentService.selectById(studentId);
    }

    @PostMapping("/save")
    public String saveStudent(@RequestBody Student student) {

        log.info("student: {}", student);

        studentService.saveStudent(student);

        return student.toString();
    }

    @DeleteMapping("/delete/{studentId}")
    public String deleteStudent(@PathVariable int studentId) {

        log.warn("studentId: {}", studentId);

        studentService.deleteStudent(studentId);

        return "Deleted student id: " + studentId;
    }

    @PutMapping("/update/{studentId}")
    public String updateStudent(@PathVariable int studentId, @RequestBody Student student) {

        log.warn("student: {}", student);

        studentService.updateStudent(studentId, student);

        return "Updated " + student;
    }
}
