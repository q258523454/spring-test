package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.entity.Student;
import com.entity.Teacher;
import com.service.OtherService;
import com.service.StudentService;
import com.service.TeacherService;
import com.service.TransactionalService;
import com.util.MultiByZero;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
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

    @Autowired
    private TransactionalService transactionalService;

    @Autowired
    private OtherService otherService;

    @RequestMapping(value = "/noTransactionOrg", method = RequestMethod.GET)
    public String testTransaction() throws Exception {
        Student user1 = new Student("student_noTransacation1", "123", new Date());
        Student user2 = new Student("student_noTransacation2", "123", new Date());
        System.out.println(JSONObject.toJSONString(user1));
        System.out.println(JSONObject.toJSONString(user2));
        studentService.insertStudent(user1); // ①
        MultiByZero.multiByZero();  // 出现ArithmeticException异常, ①会插入,②不会插入
        studentService.insertStudent(user2); // ②
        return "1";
    }

    // 有效
    @Transactional
    @RequestMapping(value = "/transactionOrg", method = RequestMethod.GET)
    public String transactionOrg() throws Exception {
        Student student = new Student("student_transactionOrg", "123", new Date());
        Teacher teacher = new Teacher("teacher_transactionOrg", "123", new Date());
        System.out.println(JSONObject.toJSONString(student));
        System.out.println(JSONObject.toJSONString(teacher));
        studentService.insertStudent(student); // ①
        MultiByZero.multiByZero();  // 出现ArithmeticException异常, ①不会插入,②不会插入，因为有@Transactional
        teacherService.insertTeacher(teacher); // ②
        return "1";
    }

    // 默认为运行时异常回归, 检查异常,如IOException, 则无效
    @Transactional
    @RequestMapping(value = "/transactionOrgIOException", method = RequestMethod.GET)
    public String transactionOrgIOException() throws Exception {
        Student student = new Student("transactionOrgIOException", "123", new Date());
        Teacher teacher = new Teacher("transactionOrgIOException", "123", new Date());
        System.out.println(JSONObject.toJSONString(student));
        System.out.println(JSONObject.toJSONString(teacher));
        studentService.insertStudent(student); // ①
        FileInputStream fileInputStream = new FileInputStream("/User/no.txt");
        teacherService.insertTeacher(teacher); // ②
        return "1";
    }

    // 默认为运行时异常回滚, 检查异常,如IOException, 则无效, 修改事务rollbackFor的级别为Exception.class, 有效
    @Transactional(rollbackFor = Exception.class)
    @RequestMapping(value = "/transactionOrgIOException2", method = RequestMethod.GET)
    public String transactionOrgIOException2() throws Exception {
        Student student = new Student("transactionOrgIOException2", "123", new Date());
        Teacher teacher = new Teacher("transactionOrgIOException2", "123", new Date());
        System.out.println(JSONObject.toJSONString(student));
        System.out.println(JSONObject.toJSONString(teacher));
        studentService.insertStudent(student); // ①
        FileInputStream fileInputStream = new FileInputStream("/User/no.txt");
        teacherService.insertTeacher(teacher); // ②
        return "1";
    }


    // 通过普通方法调用事务注解的方法,无效
    @RequestMapping(value = "/callOwnTransMethod", method = RequestMethod.GET)
    public void callOwnTransMethod() throws Exception{
        transactionOrg();
    }


    // 通过普通方法调用事务注解的方法,无效
    @RequestMapping(value = "/callServiceTransInterfaceByInnerMethod", method = RequestMethod.GET)
    public void callServiceTransMethodByInnerMethod() throws Exception {
        transactionalService.callOwnPublicMethod();
    }

    // 通过spring bean, 直接调用注解方法, 有效 【常用】
    @RequestMapping(value = "/callServiceTransMethod", method = RequestMethod.GET)
    public void callServiceTransMethod() throws Exception {
        transactionalService.publicMethod();
    }

    // 通过spring bean(A), 间接调用其他spring bean(B)的注解方法, 而B是直接调用的注解方法, 有效 【常用】
    @RequestMapping(value = "/publicCallPrivateWhichCallSpringBeanTrans", method = RequestMethod.GET)
    public void publicCallPrivateWhichCallSpringBeanTrans() throws Exception {
        otherService.publicCallPrivateWhichCallSpringBeanTrans();
    }

    // 注解@Transactional方法上, 无论子方法是私有还是公有方法, 都有效
    @RequestMapping(value = "/callServiceTransInterface", method = RequestMethod.GET)
    public void callServiceTransMethodByInnerTransMethod() throws Exception {
        transactionalService.transInMethod();
    }

}

