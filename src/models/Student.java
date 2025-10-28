package models;

public class Student {
    private int student_id;
    private String name;
    private int age;
    private String city;

    public Student(int student_id, String name, int age, String city) {
        this.student_id = student_id;
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public int getId() { return student_id; }

    public void setId(int student_id) { this.student_id = student_id; }

    public String getName() { return name;}

    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }

    public String getCity() { return city; }

    public void setCity(String city) { this.city = city; }

    @Override
    public String toString(){
        final StringBuilder sb = new StringBuilder("Student{");
        sb.append("student_id=").append(student_id);
        sb.append("name=").append(name);
        sb.append("age=").append(age);
        sb.append("city=").append(city);
        sb.append("}");
        return sb.toString();
    }
}
