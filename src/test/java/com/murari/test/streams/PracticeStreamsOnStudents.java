package com.murari.test.streams;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PracticeStreamsOnStudents {

  private List<Student> studentList;

  @BeforeAll
  private void init() {
    studentList =
        Arrays.asList(
            new Student(
                1, "Rohit", "Mall", 30, "Male", "Mechanical Engineering", 2015, "Mumbai", 122),
            new Student(
                2, "Pulkit", "Singh", 56, "Male", "Computer Engineering", 2018, "Delhi", 67),
            new Student(
                3, "Ankit", "Patil", 25, "Female", "Mechanical Engineering", 2019, "Kerala", 164),
            new Student(
                4,
                "Satish Ray",
                "Malaghan",
                30,
                "Male",
                "Mechanical Engineering",
                2014,
                "Kerala",
                26),
            new Student(5, "Roshan", "Mukd", 23, "Male", "Biotech Engineering", 2022, "Mumbai", 12),
            new Student(
                6, "Chetan", "Star", 24, "Male", "Mechanical Engineering", 2023, "Karnataka", 90),
            new Student(
                7, "Arun", "Vittal", 26, "Male", "Electronics Engineering", 2014, "Karnataka", 324),
            new Student(
                8, "Nam", "Dev", 31, "Male", "Computer Engineering", 2014, "Karnataka", 433),
            new Student(
                9, "Sonu", "Shankar", 27, "Female", "Computer Engineering", 2018, "Karnataka", 7),
            new Student(
                10,
                "Shubham",
                "Pandey",
                26,
                "Male",
                "Instrumentation Engineering",
                2017,
                "Mumbai",
                98));
  }

  //    1- Find list of students whose first name starts with alphabet A
  @Test
  public void check_firstNameStartsWithA_Correct() {
    List<Student> list =
        studentList.stream().filter(student -> student.getFirstName().startsWith("A")).toList();
    Assertions.assertEquals(2, list.size());
  }

  //    2- Group The Student By Department Names
  @Test
  public void check_groupByDepartment_thenCorrect() {
    Map<String, List<Student>> departmentmap =
        studentList.stream().collect(Collectors.groupingBy(Student::getDepartmentName));
    Assertions.assertEquals(5, departmentmap.keySet().size());
  }

  // 3- Find the total count of student using stream
  @Test
  public void check_streamCount_thenCorrect() {
    Stream<Student> studentStream = studentList.stream();
    Assertions.assertEquals(studentList.size(), studentStream.count());
  }

  //    4- Find the max age of student
  @Test
  public void check_maxAgeOfStudent_thenCorrect() {
    IntSummaryStatistics statistics =
        studentList.stream().collect(Collectors.summarizingInt(Student::getAge));
    Assertions.assertEquals(56, statistics.getMax());
  }

  //    5- Find all departments names
  @Test
  public void check_departmentName_thenCorrect() {
    List<String> departmentNames =
        studentList.stream().map(Student::getDepartmentName).distinct().toList();
    Assertions.assertEquals(5, departmentNames.size());
  }

  //    6- Find the count of student in each department
  @Test
  public void check_countOfStudentInEachDepartment_thenCorrect() {
    Map<String, Long> studentCount =
        studentList.stream()
            .collect(Collectors.groupingBy(Student::getDepartmentName, Collectors.counting()));
    Long countOfStudent = (long) studentCount.values().stream().mapToInt(Long::intValue).sum();
    Assertions.assertEquals(10, countOfStudent);
  }

  //    7- Find the list of students whose age is less than 30
  @Test
  public void check_ageLessThanGivenNumber_thenCorrect() {
    long studentCount = studentList.stream().filter(student -> student.getAge() < 30).count();
    Assertions.assertEquals(6, studentCount);
  }

  //    8- Find the list of students whose rank is in between 50 and 100
  @Test
  public void check_rankBetweenGivenNumber_thenCorrect() {
    long studentCount =
        studentList.stream()
            .filter(student -> student.getRank() > 50 && student.getRank() < 100)
            .count();
    Assertions.assertEquals(3, studentCount);
  }

  //    9- Find the average age of male and female students
  @Test
  public void check_averageAgeOfMaleAndFemale() {
    Map<String, Double> averageAge =
        studentList.stream()
            .collect(
                Collectors.groupingBy(
                    Student::getGender, Collectors.averagingDouble(Student::getAge)));
    Assertions.assertEquals(2, averageAge.size());
  }

  //    10- Find the department who is having maximum number of students
  @Test
  public void check_departmentHavingMaximumStudent() {
    Map<String, Long> deparmentMap =
        studentList.stream()
            .collect(Collectors.groupingBy(Student::getDepartmentName, Collectors.counting()));
    Optional<Map.Entry<String, Long>> maxDepartment =
        deparmentMap.entrySet().stream().max(Map.Entry.comparingByValue());
    String departmentName = maxDepartment.map(Map.Entry::getKey).orElse(null);
    Assertions.assertEquals("Mechanical Engineering", departmentName);
  }

  //    11- Find the Students who stays in Delhi and sort them by their names
  @Test
  public void check_stayingInDelhiAndSortByNames_thenCorrect() {
    List<Student> students =
        studentList.stream()
            .filter(student -> student.getCity().equalsIgnoreCase("Delhi"))
            .sorted(Comparator.comparing(Student::getFirstName))
            .toList();
    Assertions.assertEquals(1, students.size());
  }

  //    12- Find the average rank in all departments
  @Test
  public void check_averageRankInAllDepartment_thenCorrect() {
    Map<String, Double> departmentMap =
        studentList.stream()
            .collect(
                Collectors.groupingBy(
                    Student::getDepartmentName, Collectors.averagingDouble(Student::getRank)));
    Assertions.assertEquals(5, departmentMap.size());
  }

  //    13- Find the highest rank in each department
  @Test
  public void check_HighestRankInAllDepartment_thenCorrect() {
    Map<String, Optional<Student>> departmentMap =
        studentList.stream()
            .collect(
                Collectors.groupingBy(
                    Student::getDepartmentName,
                    Collectors.maxBy(Comparator.comparing(Student::getRank))));
    Assertions.assertEquals(5, departmentMap.size());
  }

  //    14- Find the list of students and sort them by their rank
  @Test
  public void check_sortByRank_thenCorrect() {
    List<Student> rankSortedList =
        studentList.stream().sorted(Comparator.comparing(Student::getRank)).toList();
    Assertions.assertEquals(5, rankSortedList.size());
  }

  //    15- Find the student who has second rank
  @Test
  public void check_secondRank_thenCorrect() {
    Optional<Student> firstByRank =
        studentList.stream().sorted(Comparator.comparing(Student::getRank)).skip(1).findFirst();
    Assertions.assertTrue(firstByRank.isPresent());
    Assertions.assertEquals(5, firstByRank.get().getId());
  }

  //    16. Find the Youngest Male Student from Each Department
  @Test
  public void check_youngestMaleForEachDepartment_thenCorrect() {
    Map<String, Optional<Student>> youngestMaleByDepartment =
        studentList.stream()
            .filter(student -> student.getGender().equalsIgnoreCase("male"))
            .collect(
                Collectors.groupingBy(
                    Student::getDepartmentName,
                    Collectors.minBy(Comparator.comparing(Student::getAge))));

    Assertions.assertTrue(youngestMaleByDepartment.containsKey("Computer Engineering"));
    Assertions.assertEquals(
        "Nam", youngestMaleByDepartment.get("Computer Engineering").get().getFirstName());
    Assertions.assertEquals(
        31, youngestMaleByDepartment.get("Computer Engineering").get().getAge());
  }

  //    17.  calculate the total rank points (sum of ranks) for students from each city.
  @Test
  public void calculateTotalRankPointsByCity_thenCorrect() {
    Map<String, Integer> rankPointsMap =
        studentList.stream()
            .collect(
                Collectors.groupingBy(Student::getCity, Collectors.summingInt(Student::getRank)));

    Assertions.assertTrue(rankPointsMap.containsKey("Mumbai"));
    Assertions.assertEquals(232, rankPointsMap.get("Mumbai"));
  }

  //    18. Determine if Any Student Has a Rank Higher Than 300
  @Test
  public void checkIfAnyStudentHasHighRank_thenCorrect() {
    boolean anyStudentWithHighRank =
        studentList.stream().anyMatch(student -> student.getRank() > 300);

    Assertions.assertTrue(anyStudentWithHighRank);
  }

  //     19. find students whose first name starts with the letter 'A'.
  @Test
  public void findStudentsWithFirstNameStartingWithLetter_thenCorrect() {
    long studentsNameStartsWithA =
        studentList.stream().filter(student -> student.getFirstName().startsWith("A")).count();
    Assertions.assertEquals(2, studentsNameStartsWithA);
  }

  //    20. Calculate the Age of Each Student Squared
  @Test
  public void calculateAgeSquared_thenCorrect() {
    List<Student> stuentsAgeSquaredList =
        studentList.stream()
            .map(
                student ->
                    new Student(
                        student.getId(),
                        student.getFirstName(),
                        student.getLastName(),
                        student.getAge() * student.getAge(),
                        student.getGender(),
                        student.getDepartmentName(),
                        student.getJoinedYear(),
                        student.getCity(),
                        student.getRank()))
            .toList();

    Assertions.assertEquals(900, stuentsAgeSquaredList.get(0).getAge());
  }

  // 21.Convert Student Names to Uppercase
  @Test
  public void convertStudentNamesToUppercase_thenCorrect() {
    List<String> studentNameList =
        studentList.stream().map(student -> student.getFirstName().toUpperCase()).toList();

    Assertions.assertEquals("ROHIT", studentNameList.get(0));
  }

  //    calculate the weighted average of rank based on student age, where older students' ranks
  // contribute more weight.
  @Test
  public void calculateWeightedAverageRankByAge_thenCorrect() {
    double weightedAverageRank =
        ((studentList.stream().mapToDouble(student -> student.getAge() * student.getRank()).sum())
            / (studentList.stream().mapToInt(Student::getAge).sum()));
    Assertions.assertNotEquals(0, weightedAverageRank, 0.0);
  }
}
