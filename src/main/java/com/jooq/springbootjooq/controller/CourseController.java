package com.jooq.springbootjooq.controller;

import com.jooq.springbootjooq.generated.tables.pojos.Course;
import com.jooq.springbootjooq.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;


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
    public ResponseEntity<?> deleteCourse(@PathVariable Integer courseId) {

        log.warn("courseId: {}", courseId);

        if (courseService.selectById(courseId).isEmpty()) {
            return ResponseEntity.badRequest().body("Invalid request: Course ID does not exist");
        }

        courseService.deleteCourse(courseId);

        return  ResponseEntity.ok("Deleted course id: " + courseId);
    }

    @PutMapping("/update/{courseId}")
    public ResponseEntity<?> updateCourse(@PathVariable Integer courseId, @RequestBody Course course) {

        log.warn("course: {}", course);

        if (!Objects.equals(courseId, course.getId()) || courseService.selectById(courseId).isEmpty()) {
            return ResponseEntity.badRequest().body("Invalid request: Course ID in path does not match ID in request body or course does not exist");
        }

        courseService.updateCourse(courseId, course);

        return ResponseEntity.ok(course);
    }
}
