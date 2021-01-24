package exceptionsanderrors;

import exceptionsanderrors.exceptions.MissingStudentException;
import exceptionsanderrors.exceptions.MissingSubjectException;

import java.util.ArrayList;

public class Group {
    private String groupName;
    private ArrayList<Student> studentList = new ArrayList<>();

    public Group(String groupName) {
        this.groupName = groupName;
    }

    public void addStudent(Student student) {
        studentList.add(student);
    }

    public String getGroupName() {
        return groupName;
    }

    public Student getStudent(String studentName) throws MissingStudentException {
        if (studentList.isEmpty()) {
            throw new MissingStudentException("Missing student exception. Add student to the group: " + groupName);
        }
        for (Student student : studentList) {
            if (student.getStudentName().equalsIgnoreCase(studentName)) {
                 return student;
            }
        }
        throw new IllegalArgumentException("Student name is incorrect.");
    }

    public double getGroupAverageMarkBySubject(Subjects subject) throws MissingStudentException {
        if (studentList.isEmpty()) {
            throw new MissingStudentException("Missing student exception. Add student to the group: " + groupName);
        }
        double groupMarksBySubject = 0;
        int numberOfStudents = 0;
        for (int i = 0; i < studentList.size(); i++) {
            try {
                groupMarksBySubject += studentList.get(i).getStudentMarkBySubject(subject);
            } catch (MissingSubjectException e) {
                e.printStackTrace();
            }
            numberOfStudents ++;
        }
        return groupMarksBySubject / numberOfStudents;
    }
}
