package EmployeeSalary;
import java.util.Scanner;
class Employee{
    private String name; 
 
    public void setName(String name){
        this.name = name;
    }
    public String GetName(){
        return name; 
 
    }
    public void printName(){
        System.out.print("Name: ");
    }
    public void print(){
         // magkakalaman lang to maalin kung full or part time yung pinili
    }
    public void setMonthlySalary(double MonthlySalary){
        // magkakalaman lang to kapag na set na dun sa full time
    }
    public void setWage(double ratePerHour, int hoursWorked){
        // magkakalaman lang to kapag na set na dun sa part time
    }
}

class FullTimeEmployee extends Employee{
    private double MonthlySalary;

    @Override
    public void setMonthlySalary(double MonthlySalary){
        this.MonthlySalary = MonthlySalary;
    }
    public double getMonthlySalary(){
        return MonthlySalary;
    }
 
 
    @Override
    public void print(){
        System.out.println("Monthly Salary: " + getMonthlySalary()); 
    }
}

class PartTimeEmployee extends Employee{
    private double ratePerHour;
    private int hoursWorked;
    @Override
    public void setWage(double ratePerHour, int hoursWorked){
        this.ratePerHour = ratePerHour;
        this.hoursWorked = hoursWorked; 
    }
    public double getWage(){
        return ratePerHour * hoursWorked;
    }
 
    @Override
    public void print(){ 
        System.out.print("Wage:" + getWage());
    }
}
public class RunEmployee{   
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Employee fulltime= new FullTimeEmployee();
        Employee partime= new PartTimeEmployee();
 
        System.out.print("Enter Name: ");
        String name=input.nextLine();
        System.out.println("Press F for Full Time or P for PartTime");
        String user = input.nextLine();
        if (user.equalsIgnoreCase("F")){
            System.out.print("Enter your Monthly Salary: ");
            double salary = input.nextDouble(); 
            fulltime.setMonthlySalary(salary);
            fulltime.setName(name);
            fulltime.printName();
            System.out.println(fulltime.GetName());
            fulltime.print(); 
        }
        else if(user.equalsIgnoreCase("P")){
            System.out.println("Enter rate per hour and no. ofhours worked seperated by space:");
            System.out.println("Sample: 150 8");
            double rate = input.nextDouble();
            int hours = input.nextInt();
            partime.setWage(rate, hours);
            partime.setName(name);
            partime.printName();
            System.out.println(partime.GetName());
            partime.print();
        }
        input.close();
    }
}