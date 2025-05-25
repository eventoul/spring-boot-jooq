package com.jooq.springbootjooq.service;

import com.jooq.springbootjooq.generated.tables.pojos.Course;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.jooq.springbootjooq.generated.Tables.COURSE;

@Service
public class CourseServiceImpl implements CourseService {

    private final DSLContext dsl;

    public CourseServiceImpl(DSLContext dsl) {
        this.dsl = dsl;
    }

    @Override
    public List<Course> selectAll() {

        return dsl.selectFrom(COURSE).fetchInto(Course.class);
    }

    @Override
    public List<Course> selectById(Integer id) {

        return dsl.selectFrom(COURSE).where(COURSE.ID.eq(id)).fetchInto(Course.class);
    }

    @Override
    public void saveCourse(Course course) {
        dsl.insertInto(COURSE, COURSE.ID, COURSE.TITLE, COURSE.MANDATORY, COURSE.CREDITS, COURSE.DURATION)
                .values(course.getId(), course.getTitle(), course.getMandatory(), course.getCredits(), course.getDuration())
                .execute();
    }
}
