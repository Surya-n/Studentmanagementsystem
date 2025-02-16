package studentdb;

public class Student {
    private String id;
    private String name;
    private int age;
    private int marks;
    private static int count = 101;

    public Student(String name, int age, int marks) {
        this.id = "STU" + count++;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student [ID=" + id + ", Name=" + name + ", Age=" + age + ", Marks=" + marks + "]";
    }
}
