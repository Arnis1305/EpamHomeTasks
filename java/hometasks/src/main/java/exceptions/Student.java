package exceptions;

public class Student {
    private long studentId;
    private String studentFaculty;
    private double studentGroup;
    private int studentCourse;
    private String studentName;
    private double studentMathMark;
    private int studentPhysicsMark;
    private int studentChemistryMark;
    private int studentBiologyMark;
    public static final double SUBJECT_EXCEPTION = 1.54321;
    public static final String MISSING_STUDENT_EXCEPTION = "Null";
    public static final double MISSING_GROUP_EXCEPTION = 1.54321;
    public static final String MISSING_FACULTY_EXCEPTION = "Null";

    public Student(long studentId, String studentFaculty, int studentGroup, int studentCourse, String studentName,
                   int studentMathMark, int studentPhysicsMark, int studentChemistryMark, int studentBiologyMark) {
        this.studentId = studentId;
        this.studentFaculty = studentFaculty;
        this.studentGroup = studentGroup;
        this.studentCourse = studentCourse;
        this.studentName = studentName;
        this.studentMathMark = studentMathMark;
        this.studentPhysicsMark = studentPhysicsMark;
        this.studentChemistryMark = studentChemistryMark;
        this.studentBiologyMark = studentBiologyMark;
    }

    public Student(long studentId, String studentFaculty, int studentGroup, int studentCourse, String studentName,
                   int studentPhysicsMark, int studentChemistryMark, int studentBiologyMark) {
        this.studentId = studentId;
        this.studentFaculty = studentFaculty;
        this.studentGroup = studentGroup;
        this.studentCourse = studentCourse;
        this.studentName = studentName;
        this.studentMathMark = SUBJECT_EXCEPTION;
        this.studentPhysicsMark = studentPhysicsMark;
        this.studentChemistryMark = studentChemistryMark;
        this.studentBiologyMark = studentBiologyMark;
    }

    public Student(long studentId, String studentFaculty, int studentGroup, int studentCourse, double studentMathMark, int studentPhysicsMark, int studentChemistryMark, int studentBiologyMark) {
        this.studentId = studentId;
        this.studentFaculty = studentFaculty;
        this.studentGroup = studentGroup;
        this.studentCourse = studentCourse;
        this.studentName = MISSING_STUDENT_EXCEPTION;
        this.studentMathMark = studentMathMark;
        this.studentPhysicsMark = studentPhysicsMark;
        this.studentChemistryMark = studentChemistryMark;
        this.studentBiologyMark = studentBiologyMark;
    }

    public Student(long studentId, String studentFaculty, int studentCourse, String studentName, int studentMathMark, int studentPhysicsMark, int studentChemistryMark, int studentBiologyMark) {
        this.studentId = studentId;
        this.studentFaculty = studentFaculty;
        this.studentGroup = MISSING_GROUP_EXCEPTION;
        this.studentCourse = studentCourse;
        this.studentName = studentName;
        this.studentMathMark = studentMathMark;
        this.studentPhysicsMark = studentPhysicsMark;
        this.studentChemistryMark = studentChemistryMark;
        this.studentBiologyMark = studentBiologyMark;
    }

    public Student(long studentId, int studentGroup, int studentCourse, String studentName, int studentMathMark, int studentPhysicsMark, int studentChemistryMark, int studentBiologyMark) {
        this.studentId = studentId;
        this.studentFaculty = MISSING_FACULTY_EXCEPTION;
        this.studentGroup = studentGroup;
        this.studentCourse = studentCourse;
        this.studentName = studentName;
        this.studentMathMark = studentMathMark;
        this.studentPhysicsMark = studentPhysicsMark;
        this.studentChemistryMark = studentChemistryMark;
        this.studentBiologyMark = studentBiologyMark;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getStudentFaculty() {
        return studentFaculty;
    }

    public void setStudentFaculty(String studentFaculty) {
        this.studentFaculty = studentFaculty;
    }

    public double getStudentGroup() {
        return studentGroup;
    }

    public void setStudentGroup(int studentGroup) {
        this.studentGroup = studentGroup;
    }

    public int getStudentCourse() {
        return studentCourse;
    }

    public void setStudentCourse(int studentCourse) {
        this.studentCourse = studentCourse;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public double getStudentMathMark() {
        return studentMathMark;
    }

    public void setStudentMathMark(int studentMathMark) {
        this.studentMathMark = studentMathMark;
    }

    public int getStudentPhysicsMark() {
        return studentPhysicsMark;
    }

    public void setStudentPhysicsMark(int studentPhysicsMark) {
        this.studentPhysicsMark = studentPhysicsMark;
    }

    public int getStudentChemistryMark() {
        return studentChemistryMark;
    }

    public void setStudentChemistryMark(int studentChemistryMark) {
        this.studentChemistryMark = studentChemistryMark;
    }

    public int getStudentBiologyMark() {
        return studentBiologyMark;
    }

    public void setStudentBiologyMark(int studentBiologyMark) {
        this.studentBiologyMark = studentBiologyMark;
    }

    @Override
    public String toString() {
        return "University{" +
                "studentId=" + studentId +
                ", studentFaculty='" + studentFaculty + '\'' +
                ", studentGroup=" + studentGroup +
                ", studentCourse=" + studentCourse +
                ", studentName='" + studentName + '\'' +
                ", studentMathMark=" + studentMathMark +
                ", studentPhysicsMark=" + studentPhysicsMark +
                ", studentChemistryMark=" + studentChemistryMark +
                ", studentBiologyMark=" + studentBiologyMark +
                '}';
    }
}