package SE_Lab_Assignment_2_3.HopeMain;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import SE_Lab_Assignment_2_3.HopeDomain.Department;
import SE_Lab_Assignment_2_3.HopeDomain.Employee;
import SE_Lab_Assignment_2_3.HopeDomain.Job;
import SE_Lab_Assignment_2_3.HopeDomain.JobHistory;
import SE_Lab_Assignment_2_3.HopeTechServ.EmployeeDA;

public class HopeMain {

    public HopeMain() throws FileNotFoundException {
        // empty employee list
        List<Employee> empList = new ArrayList<>();

        // employeeDA object
        EmployeeDA employeeDA = new EmployeeDA();

        // store employee list in emplist
        empList = employeeDA.getEmployeeList();
        for (Employee employee : empList) {
            System.out.println(employee.getEmpNo() + " " +
                    employee.getLastName() + " " +
                    employee.getFirstName() + " " +
                    employee.getGender());
            System.out.println("\nEmployee Job History:");
            for (JobHistory jobHistory : employee.getJobhist()) {
                for (Department department : jobHistory.getDepartment()) {
                    System.out.println("\n  Department: " + department.getDepartmentName());
                }
                for (Job job : jobHistory.getJob()) {
                    System.out.println("  " + job.getDescription());
                }
                System.out.println("  " + jobHistory.getEffectiveDate() + " " + jobHistory.getSalary());
                System.out.println();
            }

            System.out.println("\n---------------------------------------------");
        }
    }

    public static void main(String[] args) throws IOException {
        new HopeMain();
    }
}
