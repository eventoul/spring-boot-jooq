package com.jooq.springbootjooq.service;

import com.jooq.springbootjooq.generated.tables.pojos.Student;

import java.util.List;

public interface StudentService {

    List<Student> selectAll();

    List<Student> selectById(Integer id);

    void saveStudent(Student student);
}
