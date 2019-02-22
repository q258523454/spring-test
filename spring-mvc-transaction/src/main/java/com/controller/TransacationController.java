package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.entity.Student;
import com.entity.Teacher;
import com.service.StudentService;
import com.service.TeacherService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-02-22
 */

@RestController
public class TransacationController {


    private Logger log = Logger.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    @RequestMapping(value = "/noTransactionOrg", method = RequestMethod.GET)
    public String testTransaction() throws Exception {
        Student user1 = new Student("student_noTransacation1", "123", new Date());
        Student user2 = new Student("student_noTransacation2", "123", new Date());
        System.out.println(JSONObject.toJSONString(user1));
        System.out.println(JSONObject.toJSONString(user2));
        studentService.insertStudent(user1); // ①
        multiByZero();  // 出现ArithmeticException异常, ①会插入,②不会插入
        studentService.insertStudent(user2); // ②
        return "1";
    }

    @Transactional
    @RequestMapping(value = "/transactionOrg", method = RequestMethod.GET)
    public String transactionOrg() throws Exception {
        Student user1 = new Student("student_transactionOrg", "123", new Date());
        Student user2 = new Student("student_transactionOrg", "123", new Date());
        System.out.println(JSONObject.toJSONString(user1));
        System.out.println(JSONObject.toJSONString(user2));
        studentService.insertStudent(user1); // ①
        multiByZero();  // 出现ArithmeticException异常, ①不会插入,②不会插入，因为有@Transactional
        studentService.insertStudent(user2); // ②
        return "1";
    }

    @Transactional
    @RequestMapping(value = "/transactionOrg2", method = RequestMethod.GET)
    public String transactionOrg2() throws Exception {
        Student student = new Student("student_transactionOrg2", "123", new Date());
        Teacher teacher = new Teacher("teacher_transactionOrg2", "123", new Date());
        System.out.println(JSONObject.toJSONString(student));
        System.out.println(JSONObject.toJSONString(teacher));
        studentService.insertStudent(student); // ①
        multiByZero();  // 出现ArithmeticException异常, ①不会插入,②不会插入，因为有@Transactional
        teacherService.insertTeacher(teacher); // ②
        return "1";
    }


    public static void multiByZero() {
        int a = 0;
        int b = 1 / a;
    }
}

