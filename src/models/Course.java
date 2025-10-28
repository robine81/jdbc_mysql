package models;

public class Course {
    private int course_id;
    private String course_name;
    private int credits;

    public Course(int course_id, String course_name, int credits) {
        this.course_id = course_id;
        this.course_name = course_name;
        this.credits = credits;
    }

    public Course(String course_name, int credits) {
        this.course_name = course_name;
        this.credits = credits;
    }

    public int getId() { return course_id; }

    public void setId(int course_id) { this.course_id = course_id; }

    public String getName() { return course_name; }

    public void setName(String course_name) { this.course_name = course_name; }

    public int getCredits() { return credits; }

    public void setCredits(int credits) { this.credits = credits; }

    @Override
    public String toString() {
        return "Course{" +
                "course_id=" + course_id +
                ", course_name='" + course_name + '\'' +
                ", credits=" + credits +
                '}';
    }
}
