import java.util.ArrayList;
import java.util.List;

public class Student {
    final long studentNumber;
    final String fullName;
    final ArrayList<Course> courses;

    public Student(long studentNumber, String fullName, ArrayList<Course> courses) {
        this.studentNumber = studentNumber;
        this.fullName = fullName;
        this.courses = courses;
    }

    public final void addCourse(Course course) {
        if (course.ownerCount < 5 && !this.courses.contains(course) && !course.hasConflict(this.courses) && this.courses.size() < 5) {
            this.courses.add(course);
            System.out.println("Course added.");
            course.incrementOwnerCount(1);
        } else if (course.ownerCount >= 5) {
            System.out.println("Course can not added. Because its quota is full");
        } else if (this.courses.contains(course)) {
            System.out.println("Course can not added. Because you already added this course");
        } else if (course.hasConflict(this.courses)) {
            System.out.println("Course can not added. Because you have conflicted courses");
        } else if (!(this.courses.size() < 5)) {
            System.out.println("Course can not added. Because you have 5 courses added already");
        }
    }

    public final void dropCourse(Course course) {
        if (this.courses.contains(course)) {
            this.courses.remove(course);
            System.out.println("Course dropped");
        } else {
            System.out.println("Course can not dropped because you dont have this course");
        }
    }

    public long getStudentNumber() {
        return studentNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public String getShortNameForCourses() {
        StringBuilder coursesString = new StringBuilder();

        for (Course course : courses) {
            int index = 0;
            coursesString.append(index + 1).append(" - ").append(course.courseCode).append("\n");
        };

        return coursesString.toString();
    }

    public static Student findStudentByNumber(List<Student> studentList, long studentNumber) {
        for (Student student : studentList) {
            if (student.getStudentNumber() == studentNumber) {
                return student;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return  "Std. Number: " + getStudentNumber() + " " +
                "Name: " + getFullName() + " " +
                "Courses:" + getShortNameForCourses() + " ";
    }
}
