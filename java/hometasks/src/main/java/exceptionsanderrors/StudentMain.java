package exceptionsanderrors;

import exceptionsanderrors.exceptions.*;

public class StudentMain {
    public static void main(String[] args) {
        try {
            University bntuUniversity = new University("BNTU");

            bntuUniversity.addFaculty(new Faculty("FIT"));
            bntuUniversity.addFaculty(new Faculty("TOV"));

            bntuUniversity.getFaculty("TOV").addGroup(new Group("1"));
            bntuUniversity.getFaculty("FIT").addGroup(new Group("1"));

            bntuUniversity.getFaculty("TOV").getGroup("1").addStudent(new Student("Mikola Kovach"));
            bntuUniversity.getFaculty("FIT").getGroup("1").addStudent(new Student("Artem Krishtopchik"));
            bntuUniversity.getFaculty("FIT").getGroup("1").addStudent(new Student("Daniil Chernyshev"));

            bntuUniversity.getFaculty("TOV").getGroup("1").getStudent("Mikola Kovach").addSubjectMark(Subjects.OOP, 10);
            bntuUniversity.getFaculty("TOV").getGroup("1").getStudent("Mikola Kovach").addSubjectMark(Subjects.PHYSICS, 4);
            bntuUniversity.getFaculty("FIT").getGroup("1").getStudent("Daniil Chernyshev").addSubjectMark(Subjects.OOP, 9);
            bntuUniversity.getFaculty("FIT").getGroup("1").getStudent("Daniil Chernyshev").addSubjectMark(Subjects.CHEMISTRY, 8);
            bntuUniversity.getFaculty("FIT").getGroup("1").getStudent("Artem Krishtopchik").addSubjectMark(Subjects.OOP, 9);
            bntuUniversity.getFaculty("FIT").getGroup("1").getStudent("Artem Krishtopchik").addSubjectMark(Subjects.CHEMISTRY, 8);
            bntuUniversity.getFaculty("FIT").getGroup("1").getStudent("Artem Krishtopchik").addSubjectMark(Subjects.MATH, 7);

            System.out.println("University average mark by subject: " + bntuUniversity.getUniversityAverageMarkBySubject(Subjects.OOP));
            System.out.println("Student average mark by all subjects: " + bntuUniversity.getFaculty("FIT").getGroup("1").getStudent("Artem Krishtopchik").getStudentAverageMarkByAllSubjects());
            System.out.println("Average mark by faculty, group, subject: " + bntuUniversity.getFaculty("FIT").getGroup("1").getGroupAverageMarkBySubject(Subjects.OOP));

        } catch (IllegalMarkException | MissingFacultyException | MissingGroupException | MissingStudentException | MissingSubjectException e) {
            e.printStackTrace();
        }
    }
}