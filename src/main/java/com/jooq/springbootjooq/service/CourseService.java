package com.jooq.springbootjooq.service;

import com.jooq.springbootjooq.generated.tables.pojos.Course;

import java.util.List;

public interface CourseService {

    List<Course> selectAll();

    List<Course> selectById(Integer id);

    void saveCourse(Course course);

    void deleteCourse(Integer id);

    void updateCourse(Integer courseId, Course course);
}
