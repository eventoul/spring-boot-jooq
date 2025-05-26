package com.jooq.springbootjooq.controller;

import com.jooq.springbootjooq.generated.tables.pojos.Course;
import com.jooq.springbootjooq.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Slf4j
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

    @PostMapping("/save")
    public String saveCourse(@RequestBody Course course) {

        log.info("course: {}", course);

        courseService.saveCourse(course);

        return course.toString();
    }

    @DeleteMapping("delete/{courseId}")
    public String deleteCourse(@PathVariable Integer courseId) {

        log.warn("courseId: {}", courseId);

        courseService.deleteCourse(courseId);

        return "Deleted course id: " + courseId;
    }

    @PutMapping("/update/{courseId}")
    public ResponseEntity<?> updateCourse(@PathVariable Integer courseId, @RequestBody Course course) {

        log.warn("course: {}", course);

        courseService.updateCourse(courseId, course);

        return ResponseEntity.ok(course);
    }
}
