package Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Enrollment {
    private String studentName;
    private String courseName;
    private int duration;

    public Enrollment(String studentName, String courseName, int duration) {
        this.studentName = studentName;
        this.courseName = courseName;
        this.duration = duration;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getCourseName() {
        return courseName;
    }
}

class EnrollmentAnalysisService{
    Map<String, Long> countEnrollmentsPerCourse(List<Enrollment> enrollments){
        Map<String, Long> enr = enrollments.stream().collect(Collectors.groupingBy(Enrollment::getCourseName, Collectors.counting()));
        return enr;
    }

    List<String> findMultiCourseStudents(List<Enrollment> enrollments){
        Map<String, Long> enr = enrollments.stream().collect(Collectors.groupingBy(Enrollment::getStudentName, Collectors.counting()));
        List<String> students = enr.entrySet().stream().filter(p -> p.getValue() > 1).map(p -> p.getKey()).collect(Collectors.toList());
        return students;
    }
}

class SSolution{
    public static void main(String[] args){
        ArrayList<Enrollment> enrollments = new ArrayList<>();
        enrollments.add(new Enrollment("Alice", "Java", 30));
        enrollments.add(new Enrollment("Bob", "Python", 25));
        enrollments.add(new Enrollment("Alice", "Spring", 40));
        enrollments.add(new Enrollment("David", "Java", 30));
        enrollments.add(new Enrollment("Bob", "Java", 30));

        EnrollmentAnalysisService eas = new EnrollmentAnalysisService();
        System.out.println("Enrollments per Course: " + eas.countEnrollmentsPerCourse(enrollments).toString());
        System.out.println("Multi-course Students: " + eas.findMultiCourseStudents(enrollments).toString());

    }
}
