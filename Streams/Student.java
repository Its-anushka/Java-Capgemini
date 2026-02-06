package Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Student {
    private String name;
    private int marks;

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return name + " " + marks;
    }
}

class Driver{
    public static void main(String[] args){
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Smith", 84 ));
        students.add(new Student("Allen", 67));
        students.add(new Student("King", 96));
        students.add(new Student("Alice", 52));
        students.add(new Student("Mathews", 32));

        students.stream().filter(s -> s.getMarks() > 80).forEach(System.out::println);


    }
}
