package studentdb;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Studentmanagementsystem sms = new Studentmangement();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Display Student");
            System.out.println("3. Display All Students");
            System.out.println("4. Remove Student");
            System.out.println("5. Remove All Students");
            System.out.println("6. Update Student");
            System.out.println("7. Count Students");
            System.out.println("8. Sort Students");
            System.out.println("9. Student with Highest Marks");
            System.out.println("10. Student with Lowest Marks");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> sms.addStudent();
                case 2 -> sms.displayStudent();
                case 3 -> sms.displayAllStudents();
                case 4 -> sms.removeStudent();
                case 5 -> sms.removeAllStudents();
                case 6 -> sms.updateStudent();
                case 7 -> sms.countStudents();
                case 8 -> sms.sortStudents();
                case 9 -> sms.getStudentWithHighestMarks();
                case 10 -> sms.getStudentWithLowestMarks();
                case 11 -> {
                    System.out.println("Exiting... Goodbye!");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}


