package proj1;

import java.util.ArrayList;

public class RegistrationSystem {
    private ArrayList<Student> students;

    public RegistrationSystem() {
        students = new ArrayList<>();
    }

    public boolean addStudent(Student student) {
        if (student == null || findStudent(student.getId()) != null) {
            return false;
        }
        students.add(student);
        return true;
    }

    public Student findStudent(String id) {
        for (Student s : students) {
            if (s.getId().equalsIgnoreCase(id)) {
                return s;
            }
        }
        return null;
    }

    public boolean removeStudent(String id) {
        Student s = findStudent(id);
        if (s == null) {
            return false;
        }
        students.remove(s);
        return true;
    }

    public boolean addMark(String id, double mark) {
        Student s = findStudent(id);
        return s != null && s.addMark(mark);
    }

    public boolean modifyMark(String id, int index, double newMark) {
        Student s = findStudent(id);
        return s != null && s.setMark(index, newMark);
    }

    public int getStudentCount() {
        return students.size();
    }

    public void displayAll() {
        if (students.isEmpty()) {
            System.out.println("No students registered.");
            return;
        }
        for (Student s : students) {
            System.out.println(s);
        }
    }

    public void displayPassed() {
        boolean found = false;
        for (Student s : students) {
            if (s.isPassed()) {
                System.out.println(s);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No passed students.");
        }
    }
}