package SE_Lab_Assignment_2_3.HopeTechServ;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import SE_Lab_Assignment_2_3.HopeDomain.Employee;

public class EmployeeDA {
    private List<Employee> employeeList;

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public EmployeeDA() throws FileNotFoundException {
        // read employee file
        Scanner empFile = new Scanner(new FileReader("SE_Lab_Assignment_2/csv/EMPFILE.csv"));

        // empty list
        employeeList = new ArrayList<Employee>();

        while (empFile.hasNext()) {
            String empRow = new String();
            empRow = empFile.nextLine();
            String[] empSpecific = new String[7];
            empSpecific = empRow.split(",");

            // employee object
            Employee employee = new Employee();

            // set data of employee object
            employee.setEmpNo(empSpecific[0]);
            employee.setLastName(empSpecific[1]);
            employee.setFirstName(empSpecific[2]);
            employee.setGender(empSpecific[3]);

            // insert JobHistDA object
            JobHistDA jobhistDA = new JobHistDA(employee.getEmpNo());
            employee.setJobhist(jobhistDA.getJobhist());

            // add employee object to employee list
            employeeList.add(employee);

        }
    }
}
