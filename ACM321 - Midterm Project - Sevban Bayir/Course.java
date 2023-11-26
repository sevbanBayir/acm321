import java.time.LocalTime;
import java.util.List;

public class Course {
    final String courseCode;
    int ownerCount;
    final String courseName;
    final LocalTime startHour;
    final LocalTime endHour;

    public Course(String courseCode, String courseName, int ownerCount, LocalTime startHour, LocalTime endHour) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.ownerCount = ownerCount;
        this.startHour = startHour;
        this.endHour = endHour;
    }

    public boolean hasConflict(List<Course> otherCourses) {
        for (Course otherCourse : otherCourses) {
            if (this.scheduleConflict(otherCourse)) {
                return true;
            }
        }
        return false;
    }

    private boolean scheduleConflict(Course otherCourse) {
        return this.getStartHour().isBefore(otherCourse.getEndHour()) &&
                this.getEndHour().isAfter(otherCourse.getStartHour());
    }

    public String getCourseCode() {
        return courseCode;
    }

    public int getOwnerCount() {
        return ownerCount;
    }

    public String getCourseName() {
        return courseName;
    }
    public LocalTime getEndHour() {
        return endHour;
    }
    public LocalTime getStartHour() {
        return startHour;
    }

    public void incrementOwnerCount(int incrementValue) {
        this.ownerCount += incrementValue;
    }
    @Override
    public String toString() {
        return
                "Course code: " + courseCode + " " +
                "Course name: " + courseName + " " +
                "Owner count: " + ownerCount + " " +
                "Start: " + startHour + " " +
                "End: " + endHour + " " +
                "\n";
    }
}

