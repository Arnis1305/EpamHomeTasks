package exceptionsanderrors;

import exceptionsanderrors.exceptions.MissingFacultyException;
import exceptionsanderrors.exceptions.MissingGroupException;

import java.util.ArrayList;

public class University {
    private String universityName;
    private ArrayList<Faculty> facultyList = new ArrayList<>();

    public University(String universityName) {
        this.universityName = universityName;
    }

    public void addFaculty(Faculty faculty) {
        facultyList.add(faculty);
    }

    public String getUniversityName() {
        return universityName;
    }

    public Faculty getFaculty(String facultyName) throws MissingFacultyException {
        if (facultyList.isEmpty()) {
            throw new MissingFacultyException("Missing faculty exception. Add faculty to the university: " + universityName);
        }
        for (Faculty faculty : facultyList) {
            if (faculty.getFacultyName().equalsIgnoreCase(facultyName)) {
                return faculty;
            }
        }
        throw new IllegalArgumentException("Faculty name is incorrect.");
    }

    public double getUniversityAverageMarkBySubject(Subjects subject) throws MissingFacultyException {
        if (facultyList.isEmpty()) {
            throw new MissingFacultyException("Missing faculty exception. Add faculty to the university: " + universityName);
        }
        double universityMarksBySubject = 0;
        int numberOfFaculties = 0;
        for (int i = 0; i < facultyList.size(); i++) {
            try {
                universityMarksBySubject += facultyList.get(i).getFacultyAverageMarkBySubject(subject);
            } catch (MissingGroupException e) {
                e.printStackTrace();
            }
            numberOfFaculties++;
        }
        return universityMarksBySubject / numberOfFaculties;
    }
}
