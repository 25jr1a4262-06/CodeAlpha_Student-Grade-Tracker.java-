import java.util.ArrayList;
import java.util.Scanner;
class Student {
    String name;
    ArrayList<Integer> grades;

    Student(String name, ArrayList<Integer> grades) {
        this.name = name;
        this.grades = grades;
    }

    double getAverage() {
        int sum = 0;

        for (int grade : grades) {
            sum += grade;
        }

        return (double) sum / grades.size();
    }

    int getHighest() {
        int highest = grades.get(0);

        for (int grade : grades) {
            if (grade > highest) {
                highest = grade;
            }
        }

        return highest;
    }

    int getLowest() {
        int lowest = grades.get(0);

        for (int grade : grades) {
            if (grade < lowest) {
                lowest = grade;
            }
        }

        return lowest;
    }

    void displayReport() {
        System.out.println("Student Name : " + name);
        System.out.println("Grades       : " + grades);
        System.out.printf("Average      : %.2f%n", getAverage());
        System.out.println("Highest      : " + getHighest());
        System.out.println("Lowest       : " + getLowest());
        System.out.println("-----------------------------------");
    }
}

public class StudentGradeManager {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {

            System.out.println("\nStudent " + (i + 1));

            System.out.print("Enter student name: ");
            String name = sc.nextLine();

            System.out.print("Enter number of subjects: ");
            int subjects = sc.nextInt();

            ArrayList<Integer> grades = new ArrayList<>();

            for (int j = 0; j < subjects; j++) {
                System.out.print("Enter grade for subject " + (j + 1) + ": ");
                int grade = sc.nextInt();
                grades.add(grade);
            }

            sc.nextLine();

            students.add(new Student(name, grades));
        }

        System.out.println("\n========== STUDENT SUMMARY REPORT ==========");

        for (Student student : students) {
            student.displayReport();
        }
        sc.close();
    }
}
