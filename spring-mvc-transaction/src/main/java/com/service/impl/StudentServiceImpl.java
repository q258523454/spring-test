package com.service.impl;

import com.dao.StudentMapper;
import com.entity.Student;
import com.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-02-22
 */

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper mapper;

    @Override
    public List<Student> selectAllStudent() {
        return mapper.selectAllStudent();
    }

    @Override
    public int insertStudent(Student student) {
        return mapper.insertStudent(student);
    }

}
