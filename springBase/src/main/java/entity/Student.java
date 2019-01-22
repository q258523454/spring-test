package entity;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-01-22
 */
public class Student {
    private String sName;

    private int age;

    private Teacher teacher;

    public Student() {
        this.sName = "Mike";
        this.age = 20;
    }

    // Spring 是根据反射机制通过实体类的 setter() 为对象赋值
    // 因此实体类的 setter() 方法是不能忽略不写的，必须提供 setter() 方法
    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
