import java.time.LocalTime;
import java.util.*;

import static java.lang.System.in;

public class CourseRegistrationApp {
    public static void main(String[] args) {
        final List<Student> students = createStudentList();
        final List<Course> courseList = createCourseList();

        Scanner scanner = new Scanner(in);

        while (true) {
            long studentNumber;
            int courseChoice;
            int choice;
            int index;
            Student student;

            System.out.println("\n===== Course Registration System =====");
            System.out.println("1. Add Course");
            System.out.println("2. Drop Course");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Please choose which course you want to add from the below list:");
                    index = 1;
                    for (Course course : courseList) {
                        System.out.println(index + ". " + course);
                        index++;
                    }
                    courseChoice = scanner.nextInt() - 1;

                    if (courseChoice < 0 || courseChoice > courseList.size()) {
                        System.out.println("Invalid course choice please enter a number between " + 1 + " - " + courseList.size());
                        break;
                    }

                    do {
                        System.out.print("Enter student number: ");
                        studentNumber = scanner.nextLong();

                        final long finalStudentNumber = studentNumber;

                        if (students.stream().noneMatch(student1 -> finalStudentNumber == student1.getStudentNumber())) {
                            System.out.println("Invalid student number, try again!");
                        } else {
                            break;
                        }

                    } while (true);

                    student = Objects.requireNonNull(Student.findStudentByNumber(students, studentNumber));

                    System.out.println(student);

                    student.addCourse(courseList.get(courseChoice));

                    System.out.println(student);

                    break;
                case 2:
                    do {
                        System.out.print("Enter student number: ");
                        studentNumber = scanner.nextLong();

                        final long finalStudentNumber = studentNumber;

                        if (students.stream().noneMatch(student1 -> finalStudentNumber == student1.getStudentNumber())) {
                            System.out.println("Invalid student number, try again!");
                        } else {
                            break;
                        }

                    } while (true);

                    student = Objects.requireNonNull(Student.findStudentByNumber(students, studentNumber));

                    if (student.courses.isEmpty()) {
                        System.out.println("You dont have any courses added so you cant drop any courses");
                        break;
                    } else {
                        System.out.println("Here is your courses, please choose which one do you want to drop \n");
                    }

                    index = 1;
                    for (Course course : student.courses) {
                        System.out.println(index + ". " + course);
                        index++;
                    }
                    courseChoice = scanner.nextInt() - 1;

                    if (courseChoice < 1 || courseChoice > student.courses.size() + 1) {
                        System.out.println("Invalid course choice please enter a number between " + 1 + " - " + student.courses.size());
                        break;
                    }

                    System.out.println(student);

                    student.dropCourse(courseList.get(courseChoice));

                    System.out.println(student);

                    break;
                case 3:
                    System.out.println("Exiting the program.");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    public static List<Course> createCourseList() {
        List<Course> courses = new ArrayList<>();

        courses.add(new Course("ACM221", "Algorithms", 0, LocalTime.of(12, 0), LocalTime.of(15, 0)));
        courses.add(new Course("ACM365", "Web Desing2", 0, LocalTime.of(9, 0), LocalTime.of(12, 0)));
        courses.add(new Course("ACM213", "System Design", 0, LocalTime.of(13, 0), LocalTime.of(16, 0)));
        courses.add(new Course("ACM211", "Database", 0, LocalTime.of(10, 0), LocalTime.of(13, 0)));
        courses.add(new Course("ACM222", "C Programming", 0, LocalTime.of(15, 0), LocalTime.of(18, 0)));
        courses.add(new Course("ACM265", "Web Design1", 0, LocalTime.of(9, 0), LocalTime.of(12, 0)));
        courses.add(new Course("ACM111", "Introduction to IT", 0, LocalTime.of(10, 0), LocalTime.of(13, 0)));
        courses.add(new Course("STAT411", "Statistics", 0, LocalTime.of(11, 0), LocalTime.of(14, 0)));
        courses.add(new Course("BBA244", "Accounting", 0, LocalTime.of(9, 0), LocalTime.of(12, 0)));
        courses.add(new Course("HTR301", "Turkish History", 0, LocalTime.of(16, 0), LocalTime.of(19, 0)));

        return courses;
    }

    public static List<Student> createStudentList() {
        List<Student> students = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            Student student = new Student(20211314004L + i, "SevbanBayir" + i, new ArrayList<>());
            students.add(student);
        }

        return students;
    }
}

