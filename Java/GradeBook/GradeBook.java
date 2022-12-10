package GradeBook;

import java.io.FileWriter;
import java.util.Scanner;

class GradeBookTest {
    private double gradeBook[][];

    public GradeBookTest(double gradeBook[][]) {
        this.gradeBook = gradeBook;
    }

    public double getAverage(double[] gradeBook) {
        int total = 0;
        for (double grade : gradeBook)
            total += grade;

        // return average of grades
        return (double) total / gradeBook.length;
    }

    public String getRemark(double[] gradeBook) {
        int total = 0;
        double average;
        for (double grade : gradeBook)
            total += grade;
        average = total / gradeBook.length;
        if (average > 74)
            return "Passed";
        else
            return "Failed";
    }

    public void outputGrades() {
        int pRem = 0, fRem = 0;
        // quiz columns
        System.out.println();
        System.out.print("         ");
        for (int quiz = 0; quiz < gradeBook[0].length; quiz++)
            System.out.printf("%10s", "Quiz" + (quiz + 1));

        System.out.printf("%11s", "Average"); // average column
        System.out.printf("%11s", "Remarks\n");
        // Grades
        for (int student = 0; student < gradeBook.length; student++) {
            System.out.print("Student#" + (student + 1));

            for (double quiz : gradeBook[student]) {
                System.out.printf("%10.2f", quiz);
            }
            double average = getAverage(gradeBook[student]);
            System.out.printf("%10.2f", average);
            String remarks = getRemark(gradeBook[student]);
            System.out.printf("%11s%n", remarks);
            if (remarks.equals("Passed"))
                pRem++;
            else
                fRem++;
        }
        System.out.println();
        System.out.println("Number of student's passed: " + pRem);
        System.out.println("Number of student's failed: " + fRem);
    }

    public String saveToFile(int studentNum, int quizNum) {
        String file = "";
        int pRem = 0, fRem = 0;
        // quiz columns
        file += "Number of students " + studentNum + "\n";
        file += "Number of quizzes " + quizNum + "\n\n";

        file += "          ";
        for (int quiz = 0; quiz < gradeBook[0].length; quiz++)
            file += "\tQuiz" + (quiz + 1);
        file += "\tAverage"; // average column
        file += "\t Remarks\n";

        // Grades
        for (int student = 0; student < gradeBook.length; student++) {
            file += "Student#" + (student + 1);

            for (double quiz : gradeBook[student]) {
                file += "\t " + quiz;
            }
            double average = getAverage(gradeBook[student]);
            file += "\t " + average;
            String remarks = getRemark(gradeBook[student]);
            file += "\t " + remarks + "\n";
            if (remarks.equals("Passed"))
                pRem++;
            else
                fRem++;
        }
        file += "\nNumber of student's passed: " + pRem + "\n";
        file += "Number of student's failed: " + fRem;
        return file;
    }

    public void Update(int studentNum, int quizNum) throws Exception {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("\nWould you like to update the file? [Y/N]: ");
            String choice = input.nextLine();
            if (choice.equalsIgnoreCase("Y")) {
                System.out.print("Which student# would you like to update then?: ");
                int studNum = input.nextInt();
                if (studNum == 0 || studNum > gradeBook.length) {
                    System.out.println("Student doesn't exist");
                    Update(studentNum, quizNum);
                } else {
                    for (int stud = 0; stud < gradeBook.length; stud++) {
                        if (studNum == (stud + 1)) {
                            for (int i = 0; i < gradeBook.length; i++) {
                                System.out.print("Student#" + studNum + " Quiz" + (i + 1) + " score: ");
                                gradeBook[stud][i] = input.nextDouble();
                            }
                            saveToFile(studentNum, quizNum);
                            FileWriter write = new FileWriter("Student.txt", false);
                            write.write(saveToFile(studentNum, quizNum));
                            write.close();
                            outputGrades();
                            Update(studentNum, quizNum);
                        }
                    }
                }
            } else {
                System.out.println();
                System.out.println("Program Terminated!!");
                return;
            }
        }
    }
}

public class GradeBook {
    public static void main(String args[]) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.print("Number of students:");
        int students = input.nextInt();
        System.out.print("Number of quizzes :");
        int quizzes = input.nextInt();
        double gradeBook[][] = new double[students][quizzes];
        System.out.println();
        for (int stud = 0; stud < gradeBook.length; stud++) {
            for (int i = 0; i < gradeBook[stud].length; i++) {
                System.out.print("Student#" + (stud + 1) + " Quiz" + (i + 1) + " score: ");
                gradeBook[stud][i] = input.nextDouble();
            }
            System.out.println();
        }
        GradeBookTest myGradeBook = new GradeBookTest(gradeBook);
        myGradeBook.outputGrades();
        FileWriter write = new FileWriter("Student.txt", false);
        write.write(myGradeBook.saveToFile(students, quizzes));
        write.close();
        myGradeBook.Update(students, quizzes);
        input.close();
    }
}