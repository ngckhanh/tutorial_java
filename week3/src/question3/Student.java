package question3;
public abstract class Student {
    private String name;
    private String major;
    private String id;

    public Student() {
        name = "Default";
        major = "Default";
        id = "Default";
    }

    public Student(String name, String major, String id) {
        this.name = name;
        this.major = major;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }

    public String getId() {
        return id;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", major='" + major + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
