package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.entity.Student;
import com.service.StudentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


@RestController
public class StudentController {

    private Logger log = Logger.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/insertStudent", method = RequestMethod.GET)
    public String insertStudent() {
        Student student = new Student();
        student.setUsername("student");
        student.setPassword("student");
        student.setRegTime(new Date());
        return "" + studentService.insertStudent(student);
    }

    @RequestMapping(value = "/selectAllStudent", method = RequestMethod.GET)
    public String selectAllStudent() {
        return JSONObject.toJSONString(studentService.selectAllStudent());
    }

}