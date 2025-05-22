package com.jooq.springbootjooq.service;

import com.jooq.springbootjooq.generated.Tables;
import com.jooq.springbootjooq.generated.tables.pojos.Course;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final DSLContext dsl;

    public CourseServiceImpl(DSLContext dsl) {
        this.dsl = dsl;
    }

    @Override
    public List<Course> selectAll() {

        return dsl.selectFrom(Tables.COURSE).fetchInto(Course.class);
    }

    @Override
    public List<Course> selectById(Integer id) {

        return dsl.selectFrom(Tables.COURSE).where(Tables.COURSE.ID.eq(id)).fetchInto(Course.class);
    }

}
