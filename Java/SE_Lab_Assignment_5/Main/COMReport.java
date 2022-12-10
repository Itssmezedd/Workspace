package SE_Lab_Assignment_5.Main;

import java.io.IOException;
import SE_Lab_Assignment_5.DA.BlockSectionDA;
import SE_Lab_Assignment_5.Domain.Course;
import SE_Lab_Assignment_5.Domain.Student;

public class COMReport {
    public static void main(String[] args) throws IOException {
        BlockSectionDA blocksectionDA = new BlockSectionDA();
        blocksectionDA.getBlockSection();

        System.out.print("Block Section: " + blocksectionDA.getBlockSection().getBlockCode() + "\t\t\t");
        System.out.println("Block Section Desription: " + blocksectionDA.getBlockSection().getDescription());
        System.out.println("Class Adviser: " + blocksectionDA.getBlockSection().getAdviser());

        for (Student student : blocksectionDA.getBlockSection().getStudentList()) {
            System.out
                    .println("--------------------------------------------------------------------------------------");
            System.out.print("\nStudent: " + student.getStudentNumber() + "\t\t");
            System.out.print("Student Name: " + student.getName() + "\t");
            System.out.println("Program: " + student.getProgram());
            System.out.println("\nSchedule");
            System.out.println("Course Code\t Description\t\tUnit\t Day\t Time\t");

            for (Course course : student.getCourseList()) {
                System.out.printf("%-17s %s", course.getCourseCode(), course.getDescription());
                System.out.print("\t\t" + course.getUnit());
                System.out.print("\t" + course.getDay() + "\t" + course.getTime());
                System.out.println();
            }
        }
    }
}
