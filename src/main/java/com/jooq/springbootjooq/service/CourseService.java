package com.jooq.springbootjooq.service;

import com.jooq.springbootjooq.generated.tables.pojos.Course;

import java.util.List;

public interface CourseService {

    List<Course> selectAll();

    List<Course> selectById(Integer id);

}
