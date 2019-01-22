package chapter11_factory.entity;

import chapter10_bean.entity.Teacher;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-01-22
 */
public class TeacherFactory {
    public Teacher createTeacher() {
        Teacher teacher = new Teacher();
        System.out.println("[动态工厂]TeacherFactory 负责创建 Teacher 实例对象！");
        return teacher;
    }

    public static Teacher createTeacherStatic() {
        Teacher teacher = new Teacher();
        System.out.println("[静态工厂]TeacherFactory 负责创建 Teacher 实例对象！");
        return teacher;
    }
}
