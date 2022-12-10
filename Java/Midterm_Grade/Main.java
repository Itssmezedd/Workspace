package Midterm_Grade;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        input();
    }

    public static void input() {
        Scanner input = new Scanner(System.in);
        String name, yearsec;
        String quiz1, quiz2, quiz3, standing, proj, exam;
        System.out.print("Enter Student Name: ");
        name = input.nextLine();
        System.out.print("Enter Year & Section: ");
        yearsec = input.nextLine();

        System.out.print("Enter Quiz 1: ");
        quiz1 = input.nextLine();
        System.out.print("Enter Quiz 2: ");
        quiz2 = input.nextLine();
        System.out.print("Enter Quiz 3: ");
        quiz3 = input.nextLine();

        System.out.print("Enter Class Standing: ");
        standing = input.nextLine();
        System.out.print("Enter Project: ");
        proj = input.nextLine();
        System.out.print("Enter Midterm Exam: ");
        exam = input.nextLine();
        input.close();

        // Output
        System.out.println();
        System.out.println("Name of Student: " + name);
        System.out.println("Year and Section: " + yearsec);
        System.out.print("Midterm Grade: ");
        System.out.printf("%.2f", computedAverage(quiz1, quiz2, quiz3, standing, proj, exam));
        System.out.println("\nRemarks: " + getRemark(computedAverage(quiz1, quiz2, quiz3, standing, proj, exam)));
    }

    public static double computedAverage(String quiz1, String quiz2, String quiz3, String standing, String proj,
            String exam) {
        double average = 0;
        average = Integer.parseInt(quiz1) + Integer.parseInt(quiz2) + Integer.parseInt(quiz3)
                + Integer.parseInt(standing)
                + Integer.parseInt(proj) + Integer.parseInt(exam);
        average = average / 6;

        return (average);
    }

    public static String getRemark(double average) {
        if (average > 74)
            return "Passed";
        else
            return "Failed";
    }
}

