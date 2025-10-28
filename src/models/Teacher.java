package models;

public class Teacher {
    private int id;
    private String name;
    private String department;

    public Teacher(int teacher_id, String name, String department) {
        this.id = teacher_id;
        this.name = name;
        this.department = department;
    }

    public Teacher(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getDepartment() { return department; }

    public void setDepartment(String department) { this.department = department; }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
