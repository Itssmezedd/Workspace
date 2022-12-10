package SE_Lab_Assignment_2_3.HopeTechServ;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import SE_Lab_Assignment_2_3.HopeDomain.Department;

public class DepartmentDA {
    List<Department> departmentList;

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    public DepartmentDA(String departmentCode) throws FileNotFoundException {
        Scanner departmentFile = new Scanner(new FileReader("SE_Lab_Assignment_2/csv/DEPFILE.csv"));

        // empty list of department
        departmentList = new ArrayList<>();

        while (departmentFile.hasNext()) {
            String departmentRow = new String();
            departmentRow = departmentFile.nextLine();
            String[] departmentSpecific = new String[2];
            departmentSpecific = departmentRow.split(",");

            // department object
            Department department = new Department();

            // set data of department
            if (departmentCode.contentEquals(departmentSpecific[0])) {
                department.setDepartmentName(departmentSpecific[1]);

                // add department in department list
                departmentList.add(department);
            }
        }

    }
}
