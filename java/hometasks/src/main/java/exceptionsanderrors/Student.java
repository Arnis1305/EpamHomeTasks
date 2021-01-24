package exceptionsanderrors;

import exceptionsanderrors.exceptions.IllegalMarkException;
import exceptionsanderrors.exceptions.MissingSubjectException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Student {
    private String studentName;
    private Map<Subjects, Integer> studentSubjectMark = new HashMap<>();

    public Student(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void addSubjectMark(Subjects subject, int mark) throws IllegalMarkException {
        if (mark < 0 || mark > 10) {
            throw new IllegalMarkException("Out of mark range exception. Enter mark between 0 and 10. Student with incorrect mark: " + studentName);
        } else {
            studentSubjectMark.put(subject, mark);
        }
    }

    public double getStudentMarkBySubject(Subjects subject) throws MissingSubjectException {
        if (studentSubjectMark.isEmpty()) {
            throw new MissingSubjectException("Missing subject exception. Add subject to the student " + studentName);
        }
        double studentMarkBySubject = studentSubjectMark.get(subject);
        return studentMarkBySubject;
    }

    public double getStudentAverageMarkByAllSubjects() throws MissingSubjectException {
        if (studentSubjectMark.isEmpty()) {
            throw new MissingSubjectException("Missing subject exception. Add subject to the student " + studentName);
        }
        double sumOfStudentMarks = 0;
        double amountOfStudentSubject = 0;
        ArrayList<Integer> listOfStudentMarks = new ArrayList<>(studentSubjectMark.values());
        for (int i = 0; i < listOfStudentMarks.size(); i++) {
            sumOfStudentMarks += listOfStudentMarks.get(i);
            amountOfStudentSubject++;
        }
        return sumOfStudentMarks / amountOfStudentSubject;
    }
}