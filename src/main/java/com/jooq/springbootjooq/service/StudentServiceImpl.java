package com.jooq.springbootjooq.service;

import com.jooq.springbootjooq.generated.tables.pojos.Student;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.jooq.springbootjooq.generated.Tables.STUDENT;

@Service
public class StudentServiceImpl implements StudentService {

    private final DSLContext dsl;

    public StudentServiceImpl(DSLContext dsl) {
        this.dsl = dsl;
    }

    @Override
    public List<Student> selectAll() {
        return dsl.selectFrom(STUDENT).fetchInto(Student.class);
    }

    @Override
    public List<Student> selectById(Integer id) {
        return dsl.selectFrom(STUDENT).where(STUDENT.ID.eq(id)).fetchInto(Student.class);
    }

    @Override
    public void saveStudent(Student student) {
        dsl.insertInto(STUDENT, STUDENT.ID, STUDENT.EMAIL, STUDENT.FIRST_NAME, STUDENT.LAST_NAME)
                .values(student.getId(), student.getEmail(), student.getFirstName(), student.getLastName())
                .execute();
    }

    @Override
    public void deleteStudent(Integer id) {
        dsl.deleteFrom(STUDENT).where(STUDENT.ID.eq(id)).execute();
    }
}
