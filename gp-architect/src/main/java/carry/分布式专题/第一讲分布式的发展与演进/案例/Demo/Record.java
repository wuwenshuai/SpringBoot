package carry.分布式专题.第一讲分布式的发展与演进.案例.Demo;


public class Record {
    private String level;
    private String teacherName;
    private String stuName;

    public Record(String level, String teacherName, String stuName) {
        this.level = level;
        this.teacherName = teacherName;
        this.stuName = stuName;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }
}
