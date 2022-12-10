package MainPackage.Employee;

public class Employeeinfo {
    public String employeeName;
    public String designation;
    public String academicPos;

    public void display_Employee() {
        System.out.println("\n\nEMPLOYEE DETAILS:");
        System.out.println("Employee Name: " + getName());
        System.out.println("Designation: " + getDesignation());
        System.out.println("Academic Position: " + getAcadPos());
    }

    public String getName() {
        return this.employeeName;
    }

    public void setName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDesignation() {
        return this.designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getAcadPos() {
        return this.employeeName;
    }

    public void setAcadPos(String employeeName) {
        this.employeeName = employeeName;
    }
}
