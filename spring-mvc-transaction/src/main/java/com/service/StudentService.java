package com.service;

import com.entity.Student;

import java.util.List;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-02-22
 */
public interface StudentService {
    public List<Student> selectAllStudent();

    public int insertStudent(Student student);
}
