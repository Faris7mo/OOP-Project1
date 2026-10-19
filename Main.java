package proj1;

import java.util.Scanner;

public class Main {
    private static Scanner input = new Scanner(System.in);
    private static RegistrationSystem system = new RegistrationSystem();

    public static void main(String[] args) {
        int choice;
        do {
            printMenu();
            choice = readInt("Enter your choice: ");
            switch (choice) {
                case 1: addStudent(); break;
                case 2: addMarks(); break;
                case 3: modifyMark(); break;
                case 4: showStudent(); break;
                case 5: system.displayAll(); break;
                case 6: system.displayPassed(); break;
                case 7: removeStudent(); break;
                case 0: System.out.println("Goodbye!"); break;
                default: System.out.println("Invalid choice.");
            }
            System.out.println();
        } while (choice != 0);
    }

    private static void printMenu() {
        System.out.println("===== Student Registration System =====");
        System.out.println("1. Add student");
        System.out.println("2. Enter marks");
        System.out.println("3. Modify a mark");
        System.out.println("4. Show student");
        System.out.println("5. Show all students");
        System.out.println("6. Show passed students");
        System.out.println("7. Remove student");
        System.out.println("0. Exit");
    }

    private static void addStudent() {
        String id = readLine("Student ID: ");
        String name = readLine("Student name: ");
        int type = readInt("Type (1 = Undergraduate, 2 = Graduate): ");

        Student student;
        if (type == 1) {
            student = new UndergradStudent(id, name);
        } else if (type == 2) {
            student = new GradStudent(id, name);
        } else {
            System.out.println("Invalid type.");
            return;
        }

        if (system.addStudent(student)) {
            System.out.println("Student added.");
        } else {
            System.out.println("A student with this ID already exists.");
        }
    }

    private static void addMarks() {
        String id = readLine("Student ID: ");
        Student s = system.findStudent(id);
        if (s == null) {
            System.out.println("Student not found.");
            return;
        }
        int count = readInt("How many marks? ");
        for (int i = 1; i <= count; i++) {
            double mark = readDouble("Mark " + i + " (0-100): ");
            while (!s.addMark(mark)) {
                mark = readDouble("Invalid mark. Enter again (0-100): ");
            }
        }
        System.out.println("Marks saved.");
    }

    private static void modifyMark() {
        String id = readLine("Student ID: ");
        Student s = system.findStudent(id);
        if (s == null) {
            System.out.println("Student not found.");
            return;
        }
        if (s.getMarksCount() == 0) {
            System.out.println("This student has no marks yet.");
            return;
        }
        for (int i = 0; i < s.getMarksCount(); i++) {
            System.out.println((i + 1) + ". " + s.getMark(i));
        }
        int number = readInt("Mark number to modify: ");
        double newMark = readDouble("New mark (0-100): ");
        if (system.modifyMark(id, number - 1, newMark)) {
            System.out.println("Mark updated.");
        } else {
            System.out.println("Invalid mark number or value.");
        }
    }

    private static void showStudent() {
        String id = readLine("Student ID: ");
        Student s = system.findStudent(id);
        System.out.println(s == null ? "Student not found." : s.toString());
    }

    private static void removeStudent() {
        String id = readLine("Student ID: ");
        System.out.println(system.removeStudent(id) ? "Student removed." : "Student not found.");
    }

    private static String readLine(String prompt) {
        System.out.print(prompt);
        return input.nextLine().trim();
    }

    private static int readInt(String prompt) {
        while (true) {
            try {
                return Integer.parseInt(readLine(prompt));
            } catch (NumberFormatException e) {
                System.out.println("Please enter a whole number.");
            }
        }
    }

    private static double readDouble(String prompt) {
        while (true) {
            try {
                return Double.parseDouble(readLine(prompt));
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
            }
        }
    }
}