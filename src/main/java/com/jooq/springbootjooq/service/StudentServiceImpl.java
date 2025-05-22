package com.jooq.springbootjooq.service;

import com.jooq.springbootjooq.generated.Tables;
import com.jooq.springbootjooq.generated.tables.pojos.Student;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final DSLContext dsl;

    public StudentServiceImpl(DSLContext dsl) {
        this.dsl = dsl;
    }

    @Override
    public List<Student> selectAll() {

        return dsl.selectFrom(Tables.STUDENT).fetchInto(Student.class);
    }

    @Override
    public List<Student> selectById(Integer id) {

        return dsl.selectFrom(Tables.STUDENT).where(Tables.STUDENT.ID.eq(id)).fetchInto(Student.class);
    }
}
