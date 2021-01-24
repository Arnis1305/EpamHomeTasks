package exceptionsanderrors;

import exceptionsanderrors.exceptions.MissingGroupException;
import exceptionsanderrors.exceptions.MissingStudentException;

import java.util.ArrayList;

public class Faculty {
    private String facultyName;
    private ArrayList<Group> groupList = new ArrayList<>();

    public Faculty(String facultyName) {
        this.facultyName = facultyName;
    }

    public void addGroup(Group group) {
        groupList.add(group);
    }

    public String getFacultyName() {
        return facultyName;
    }

    public Group getGroup(String groupName) throws MissingGroupException {
        if (groupList.isEmpty()) {
            throw new MissingGroupException("Missing group exception. Add group to the faculty: " + facultyName);
        }
        for (Group group : groupList) {
            if (group.getGroupName().equalsIgnoreCase(groupName)) {
                return group;
            }
        }
        throw new IllegalArgumentException("Group name is incorrect.");
    }

    public double getFacultyAverageMarkBySubject(Subjects subject) throws MissingGroupException {
        if (groupList.isEmpty()) {
            throw new MissingGroupException("Missing group exception. Add group to the faculty: " + facultyName);
        }
        double facultyMarksBySubject = 0;
        int numberOfGroups = 0;
        for (int i = 0; i < groupList.size(); i++) {
            try {
                facultyMarksBySubject += groupList.get(i).getGroupAverageMarkBySubject(subject);
            } catch (MissingStudentException e) {
                e.printStackTrace();
            }
            numberOfGroups++;
        }
        return facultyMarksBySubject / numberOfGroups;
    }
}
