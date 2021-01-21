package exceptions;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentMarks {
    Scanner scanner = new Scanner(System.in);
    private ArrayList<Student> studentsList = new ArrayList<>();
    private double averageMarkOfStudent;
    private double mathMarksByFacultyAndGroup = 0.0;
    private int amountOfStudentsByFacultyAndGroup = 0;
    private double averageMathMarks;

    public void addStudent(Student studentToAdd) throws StudentException {
        for (Student student : studentsList) {
            double mathMark = student.getStudentMathMark();
            double physicsMark = student.getStudentPhysicsMark();
            double chemistryMark = student.getStudentChemistryMark();
            double biologyMark = student.getStudentBiologyMark();
            if (mathMark < 0 || mathMark > 10 || physicsMark < 0 || physicsMark > 10 || chemistryMark < 0 || chemistryMark > 10 || biologyMark < 0 || biologyMark > 10) {
                throw new StudentException("Not a valid mark! Please enter mark number between 0 and 10! ");
            } else if (mathMark == Student.SUBJECT_EXCEPTION) {
                throw new StudentException("Missing subject exception! Please add subject to the student! ");
            } else if (student.getStudentName().contentEquals(Student.MISSING_STUDENT_EXCEPTION)) {
                throw new StudentException("Missing student exception! Please enter student name! ");
            } else if (student.getStudentGroup() == Student.MISSING_GROUP_EXCEPTION) {
                throw new StudentException("Missing group exception! Please enter group number! ");
            } else if (student.getStudentFaculty().contentEquals(Student.MISSING_FACULTY_EXCEPTION)) {
                throw new StudentException("Missing faculty exception! Please enter faculty name! ");
            }
        }
        studentsList.add(studentToAdd);
    }

    public void getStudentList() {
        System.out.println("Full list of students: ");
        studentsList.forEach(System.out::println);
    }

    public void getStudentAverageMark() {
        for (Student student : studentsList) {
            if (student.getStudentName().contentEquals("Nikita Rak")) {
                double mathMark = student.getStudentMathMark();
                double physicsMark = student.getStudentPhysicsMark();
                double chemistryMark = student.getStudentChemistryMark();
                double biologyMark = student.getStudentBiologyMark();
                averageMarkOfStudent = (mathMark + physicsMark + chemistryMark + biologyMark) / 4;
            }
        }
        System.out.println("\nStudent Nikita Rak, average mark: " + averageMarkOfStudent);
    }

    public void getSubjectAverageMarkByFacultyAndGroup() {
        for (Student student : studentsList) {
            if (student.getStudentFaculty().contentEquals("FIT") && student.getStudentGroup() == 1) {
                mathMarksByFacultyAndGroup += student.getStudentMathMark();
                amountOfStudentsByFacultyAndGroup++;
            }
        }
        System.out.println("\nFaculty - FIT, group - 1, students average mark in math: " + mathMarksByFacultyAndGroup / amountOfStudentsByFacultyAndGroup);
    }

    public void getMathAverageMark() {
        for (Student student : studentsList) {
            averageMathMarks += student.getStudentMathMark();
        }
        System.out.println("\nMath average mark in University: " + averageMathMarks / studentsList.size());
    }
}