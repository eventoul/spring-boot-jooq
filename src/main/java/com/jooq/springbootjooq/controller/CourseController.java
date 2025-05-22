package com.jooq.springbootjooq.controller;

import com.jooq.springbootjooq.generated.tables.pojos.Course;
import com.jooq.springbootjooq.service.CourseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/list")
    public List<Course> getCourses() {

        return courseService.selectAll();
    }

    @GetMapping("/detail/{courseId}")
    public List<Course> getCourseById(@PathVariable int courseId) {

        return courseService.selectById(courseId);
    }
}
