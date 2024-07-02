package com.interview;


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        System.out.println(generate(5));
        Student s1 = new Student(1, "Rohit", "Mall", 30, "Male", "Mechanical Engineering", 2015, "Mumbai", 122);
        Student s2 = new Student(2, "Pulkit", "Singh", 56, "Male", "Computer Engineering", 2018, "Delhi", 67);
        Student s3 = new Student(3, "Ankit", "Patil", 25, "Female", "Mechanical Engineering", 2019, "Kerala", 164);
        Student s4 = new Student(3, "Ankit", "Patil", 25, "Female", "Mechanical Engineering", 2019, "Kerala", 164);
        Set<Student> studentSet = new HashSet<>();
        studentSet.add(s3);
        studentSet.add(s4);
        System.out.println(studentSet);
    }

    public static List<Integer> generate(int series) {
        return Stream.iterate(new int[]{0, 1}, s ->
                        new int[]{s[1], s[0] + s[1]}
                )
                .limit(series)
                .map(n -> n[0])
                .collect(Collectors.toList());
    }
}
