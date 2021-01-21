package exceptions;

public class StudentMain {
    public static void main(String[] args) {
        StudentMarks bstuStudents = new StudentMarks();
        try {
            bstuStudents.addStudent(new Student(0, "FIT", 1, 1, "Nikita Rak", 10, 8, 10, 8));
            bstuStudents.addStudent(new Student(1, "FIT", 1, 1, "Artem Krisht", 4, 5, 4, 5));
            bstuStudents.addStudent(new Student(3, "TOV", 2, 1, "Hadina Usupova", 3, 4, 8, 5));
            bstuStudents.addStudent(new Student(4, "HTiT", 3, 1, "Alexey Ergozhin", 9, 7, 9, 7));
            bstuStudents.addStudent(new Student(5, "FMO", 2, 1, "Lexus Leha", 2, 2, 4, 5));
        } catch (StudentException e) {
            e.printStackTrace();
        }

        bstuStudents.getStudentList();
        bstuStudents.getStudentAverageMark();
        bstuStudents.getSubjectAverageMarkByFacultyAndGroup();
        bstuStudents.getMathAverageMark();
    }
}