package chapter13_DI.entity;

import java.util.List;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-01-23
 */
public class Teacher {

    private String teacherName;

    private String friendArray[];

    private List<String> school;

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String[] getFriendArray() {
        return friendArray;
    }

    public void setFriendArray(String[] friendArray) {
        this.friendArray = friendArray;
    }

    public List<String> getSchool() {
        return school;
    }

    public void setSchool(List<String> school) {
        this.school = school;
    }
}
