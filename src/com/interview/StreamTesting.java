package com.interview;

import java.util.*;
import java.util.stream.Collectors;

public class StreamTesting {

    public static void main(String[] args) {
        List<Student> studentList = loadStudents();

        //1- Find list of students whose first name starts with alphabet A
        List<Student> startsWithA = studentList.stream().filter(s -> s.getFirstName().startsWith("A")).collect(Collectors.toList());
        System.out.println(startsWithA);

        //2- Group The Student By Department Names
        Map<String, List<Student>> studentsByDepartment = studentList.stream().collect(Collectors.groupingBy(s -> s.getDepartmentName()));
        System.out.println(studentsByDepartment);

        //3- Find the total count of student using stream
        long count = studentList.stream().count();
        System.out.println(count);

        //4- Find the max age of student
        Optional<Student> maxAgeStudent = studentList.stream().max(Comparator.comparingInt(Student::getAge));
        OptionalInt maxAge = studentList.stream().mapToInt(s -> s.getAge()).max();
        System.out.println(maxAge.getAsInt());

        //5- Find all departments names
        List<String> departments = studentList.stream().map(s -> s.getDepartmentName()).distinct()
                .collect(Collectors.toList());
        System.out.println(departments);

        //6- Find the count of student in each department
        Map<String, Long> studentCount = studentList.stream().collect(Collectors.groupingBy(s -> s.getDepartmentName(), Collectors.counting()));
        System.out.println(studentCount);

        //7- Find the list of students whose age is less than 30
        List<Student> studentsLessThan30 = studentList.stream().filter(s -> s.getAge() < 30).collect(Collectors.toList());
        System.out.println(studentsLessThan30);

        //8- Find the list of students whose rank is in between 50 and 100
        List<Student> studentsByRank = studentList.stream().filter(s -> s.getRank() >= 50 && s.getRank() <= 100).collect(Collectors.toList());
        System.out.println(studentsByRank);

        //9- Find the average age of male and female students
        Map<String, Double> avgAge = studentList.stream()
                .collect(Collectors.groupingBy(s -> s.getGender(), Collectors.averagingDouble(Student::getAge)));
        System.out.println(avgAge);

        //10- Find the department who is having maximum number of students
        Map.Entry<String, Long> maxDepartment = studentList.stream().collect(Collectors.groupingBy(Student::getDepartmentName, Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).get();
        System.out.println(maxDepartment);

        //11- Find the Students who stays in Delhi and sort them by their names
        List<Student> sortedStudents = studentList.stream().filter(s -> s.getCity().equals("Delhi"))
                .sorted(Comparator.comparing(Student::getFirstName))
                .collect(Collectors.toList());
        System.out.println(sortedStudents);

        //12- Find the average rank in all departments
        Map<String, Double> avgRankInDepartments = studentList.stream()
                .collect(Collectors.groupingBy(Student::getDepartmentName, Collectors.averagingDouble(Student::getRank)));
        System.out.println(avgRankInDepartments);

        //13- Find the highest rank in each department
        Map<String, Optional<Student>> HighestRank = studentList.stream()
                .collect(Collectors.groupingBy(Student::getDepartmentName, Collectors.minBy(Comparator.comparing(Student::getRank))));
        System.out.println(HighestRank);

        //14- Find the list of students and sort them by their rank
        List<Student> stuRankSorted = studentList.stream().sorted(Comparator.comparing(Student::getRank))
                .collect(Collectors.toList());
        System.out.println("List of students sorted by their rank  : " + stuRankSorted);

        //15- Find the student who has second rank
        Student student = studentList.stream().sorted(Comparator.comparing(Student::getRank))
                .skip(1).findFirst().get();
        System.out.println(student);

        int sum = Arrays.stream(new int[]{1, 2, 3})
                .filter(i -> i >= 2)
                .map(i -> i * 3)
                .sum();
        System.out.println(sum);

    }

    public static List<Student> loadStudents() {
        return Arrays.asList(
                new Student(1, "Rohit", "Mall", 30, "Male", "Mechanical Engineering", 2015, "Mumbai", 122),
                new Student(2, "Pulkit", "Singh", 56, "Male", "Computer Engineering", 2018, "Delhi", 67),
                new Student(3, "Ankit", "Patil", 25, "Female", "Mechanical Engineering", 2019, "Kerala", 164),
                new Student(4, "Satish Ray", "Malaghan", 30, "Male", "Mechanical Engineering", 2014, "Kerala", 26),
                new Student(5, "Roshan", "Mukd", 23, "Male", "Biotech Engineering", 2022, "Mumbai", 12),
                new Student(6, "Chetan", "Star", 24, "Male", "Mechanical Engineering", 2023, "Karnataka", 90),
                new Student(7, "Arun", "Vittal", 26, "Male", "Electronics Engineering", 2014, "Karnataka", 324),
                new Student(8, "Nam", "Dev", 31, "Male", "Computer Engineering", 2014, "Karnataka", 433),
                new Student(9, "Sonu", "Shankar", 27, "Female", "Computer Engineering", 2018, "Karnataka", 7),
                new Student(10, "Shubham", "Pandey", 26, "Male", "Instrumentation Engineering", 2017, "Mumbai", 98));
    }
}
