package MainPackage;

import MainPackage.Student.*;
import MainPackage.Employee.*;
import java.util.Scanner;

class MainProgram {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Studentinfo student = new Studentinfo();
        System.out.println("STUDENT DETAILS:");
        System.out.print("Name: ");
        String student_name = input.nextLine();
        student.setName(student_name);
        System.out.print("Age: ");
        int age = Integer.parseInt(input.nextLine());
        student.setAge(age);
        System.out.print("Gender: ");
        String gender = input.nextLine();
        student.setGender(gender);
        System.out.print("Address: ");
        String address = input.nextLine();
        student.setAddress(address);
        System.out.print("Contact: ");
        double contact = Double.parseDouble(input.nextLine());
        student.setContact(contact);
        System.out.print("Father: ");
        String father = input.nextLine();
        student.setFather(father);
        System.out.print("Mother: ");
        String mother = input.nextLine();
        student.setMother(mother);

        Employeeinfo employee = new Employeeinfo();

        System.out.println("\nEMPLOYEE DETAILS");
        System.out.print("Name: ");
        String employee_name = input.nextLine();
        employee.setName(employee_name);
        System.out.print("Designation: ");
        String designation = input.nextLine();
        employee.setDesignation(designation);
        System.out.print("Academic Position: ");
        String acadPos = input.nextLine();
        employee.setAcadPos(acadPos);

        student.display_Student();
        employee.display_Employee();

        input.close();
    }
}
