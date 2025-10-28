import controllers.CourseController;
import controllers.StudentController;
import controllers.TeacherController;

import java.util.Scanner;

public class App {
    Scanner sc = new Scanner(System.in);
    StudentController studentController = new StudentController();
    CourseController courseController = new CourseController();
    TeacherController teacherController = new TeacherController();

    public void runMenu(){

        while(true) {
            System.out.println("=== MENU ===");
            System.out.println("1. Show all students");
            System.out.println("2. Add student");
            System.out.println("3. Show all course");
            System.out.println("4. Add course");
            System.out.println("5. Show all teachers");
            System.out.println("6. Add teacher");

            /*System.out.println("3. radera en person");
            System.out.println("4. hämta person baserat på id");
            System.out.println("5. uppdatera en person");*/
            System.out.println("0. avsluta");

            int input = getAnInt();

            switch (input) {
                case 1 -> getAllStudents();
                case 2 -> addStudent();
                case 3 -> getAllCourses();
                case 4 -> addCourse();
                case 5 -> getAllTeachers();
                case 6 -> addTeacher();
                /*case 3 -> deletePerson();
                case 4 -> findById();
                case 5 -> updatePerson();*/
                case 0 -> {
                    return;
                }
            }
        }
    }

    private int getAnInt() {
        while(!sc.hasNextInt()){
            System.out.println("ange ett heltal");
            sc.nextLine();
        }
        int input = sc.nextInt();
        sc.nextLine();
        return input;
    }

    private void getAllStudents(){
        studentController.getAllStudents();
    }

    private void getAllCourses(){
        courseController.getAllCourses();
    }

    private void getAllTeachers(){
        teacherController.getAllTeachers();
    }

    private void addStudent(){
        System.out.println("Enter name: ");
        String name = sc.nextLine();
        int age = 0;
        while (age == 0){
        System.out.println("Enter age: ");
        age = sc.nextInt();
        sc.nextLine();
        if(age > 0){
            break;
        } else {
            System.out.println("Age should be older than 0");
        }
        }

        System.out.println("Enter city: ");
        String city = sc.nextLine();

        studentController.addStudent(name, age, city);
    }

    private void addCourse() {
        System.out.println("Enter course name: ");
        String course_name = sc.nextLine();
        int credits = 0;
        while (credits == 0){
            System.out.println("Enter credits: ");
            credits = sc.nextInt();
            sc.nextLine();
            if(credits > 0){
                break;
            } else {
                System.out.println("Credits should be bigger than 0");
            }
        }

        courseController.addCourse(course_name, credits);
    }

    private void addTeacher() {
        System.out.println("Enter teacher's name: ");
        String name = sc.nextLine();
        System.out.println("Enter teacher's department: ");
        String department = sc.nextLine();

        teacherController.addTeacher(name, department);
    }
}
