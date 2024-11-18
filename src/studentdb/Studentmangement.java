package studentdb;

import java.util.*;

public class Studentmangement implements Studentmanagementsystem {
    private Scanner sc = new Scanner(System.in);
    private Map<String, Student> db = new LinkedHashMap<>();

    @Override
    public void addStudent() {
        System.out.println("Enter student's name:");
        String name = sc.nextLine();
        System.out.println("Enter student's age:");
        int age = sc.nextInt();
        System.out.println("Enter student's marks:");
        int marks = sc.nextInt();
        sc.nextLine(); // Consume the newline
        Student s = new Student(name, age, marks);
        db.put(s.getId(), s);
        System.out.println("Student added successfully! ID: " + s.getId());
    }

    @Override
    public void displayStudent() {
        System.out.println("Enter student ID:");
        String id = sc.nextLine().toUpperCase();
        if (db.containsKey(id)) {
            System.out.println(db.get(id));
        } else {
            try {
                throw new StudentNotFoundException("Student with ID " + id + " not found.");
            } catch (StudentNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public void displayAllStudents() {
        if (db.isEmpty()) {
            try {
                throw new StudentException("No students available to display.");
            } catch (StudentException e) {
                System.out.println(e.getMessage());
            }
        } else {
            db.values().forEach(System.out::println);
        }
    }

    @Override
    public void removeStudent() {
        System.out.println("Enter student ID:");
        String id = sc.nextLine().toUpperCase();
        if (db.remove(id) != null) {
            System.out.println("Student removed successfully.");
        } else {
            try {
                throw new StudentNotFoundException("Student with ID " + id + " not found.");
            } catch (StudentNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public void removeAllStudents() {
        if (db.isEmpty()) {
            try {
                throw new StudentException("No students to remove.");
            } catch (StudentException e) {
                System.out.println(e.getMessage());
            }
        } else {
            db.clear();
            System.out.println("All students removed.");
        }
    }

    @Override
    public void updateStudent() {
        System.out.println("Enter student ID:");
        String id = sc.nextLine().toUpperCase();
        if (db.containsKey(id)) {
            Student s = db.get(id);
            System.out.println("Enter new name (current: " + s.getName() + "):");
            s.setName(sc.nextLine());
            System.out.println("Enter new age (current: " + s.getAge() + "):");
            s.setAge(sc.nextInt());
            System.out.println("Enter new marks (current: " + s.getMarks() + "):");
            s.setMarks(sc.nextInt());
            sc.nextLine(); // Consume the newline
            System.out.println("Student updated successfully.");
        } else {
            try {
                throw new StudentNotFoundException("Student with ID " + id + " not found.");
            } catch (StudentNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public void countStudents() {
        System.out.println("Total students: " + db.size());
    }

    @Override
    public void sortStudents() {
        if (db.isEmpty()) {
            System.out.println("No students to sort.");
        } else {
            db.values().stream()
                .sorted(Comparator.comparing(Student::getName))
                .forEach(System.out::println);
        }
    }

    @Override
    public void getStudentWithHighestMarks() {
        if (db.isEmpty()) {
            System.out.println("No students available.");
        } else {
            Student max = db.values().stream().max(Comparator.comparing(Student::getMarks)).orElse(null);
            System.out.println("Student with highest marks: " + max);
        }
    }

    @Override
    public void getStudentWithLowestMarks() {
        if (db.isEmpty()) {
            System.out.println("No students available.");
        } else {
            Student min = db.values().stream().min(Comparator.comparing(Student::getMarks)).orElse(null);
            System.out.println("Student with lowest marks: " + min);
        }
    }
}
