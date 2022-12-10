 package SE_Lab_Assignment_2_3.HopeDomain;

import java.util.List;

public class Employee {
    private String empNo;
    private String lastName;
    private String firstName;
    private String gender;
    private List<JobHistory> jobhist;

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<JobHistory> getJobhist() {
        return jobhist;
    }

    public void setJobhist(List<JobHistory> jobhist) {
        this.jobhist = jobhist;
    }
}
