package com.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.dao.StudentMapper;
import com.dao.TeacherMapper;
import com.entity.Student;
import com.entity.Teacher;
import com.service.TransactionalService;
import com.util.MultiByZero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-02-22
 */

@Service
public class TransactionalServiceImpl implements TransactionalService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private TeacherMapper teacherMapper;

    public void TransactionalMethodTest() {
        Student student = new Student("student_transactionOrg2", "123", new Date());
        Teacher teacher = new Teacher("teacher_transactionOrg2", "123", new Date());
        System.out.println(JSONObject.toJSONString(student));
        System.out.println(JSONObject.toJSONString(teacher));
        studentMapper.insertStudent(student); // ①
        MultiByZero.multiByZero();  // 出现ArithmeticException异常, ①不会插入,②不会插入，因为有@Transactional
        teacherMapper.insertTeacher(teacher); // ②
    }


    /**
     * 在公有方法上事务注解, 再通过接口方法调用, 无效
     * 注意:私有方法上事务注解本身就无效(无需测试)
     */
    @Override
    public void callOwnPublicMethod() {
        publicMethod(); // 无效
    }

    /**
     * 在接口方法上加事务, 无论调用私有还是公有方法, 都有效
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void transInMethod() {
        privateMethod(); // 有效
//         publicMethod(); // 有效
    }


    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    private void privateMethod() {
        Student student = new Student("student_privateMethod", "123", new Date());
        Teacher teacher = new Teacher("teacher_privateMethod", "123", new Date());
        System.out.println(JSONObject.toJSONString(student));
        System.out.println(JSONObject.toJSONString(teacher));
        studentMapper.insertStudent(student); // ①
        MultiByZero.multiByZero();  // 出现ArithmeticException异常, ①不会插入,②不会插入，因为有@Transactional
        teacherMapper.insertTeacher(teacher); // ②
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void publicMethod() {
        Student student = new Student("student_publicMethod", "123", new Date());
        Teacher teacher = new Teacher("teacher_publicMethod", "123", new Date());
        System.out.println(JSONObject.toJSONString(student));
        System.out.println(JSONObject.toJSONString(teacher));
        studentMapper.insertStudent(student); // ①
        MultiByZero.multiByZero();  // 出现ArithmeticException异常, ①不会插入,②不会插入，因为有@Transactional
        teacherMapper.insertTeacher(teacher); // ②
    }

}
