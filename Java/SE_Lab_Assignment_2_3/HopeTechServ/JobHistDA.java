package SE_Lab_Assignment_2_3.HopeTechServ;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import SE_Lab_Assignment_2_3.HopeDomain.JobHistory;

public class JobHistDA {
    private List<JobHistory> jobHisList;

    public List<JobHistory> getJobhist() {
        return jobHisList;
    }

    public void setJobhist(List<JobHistory> jobHisList) {
        this.jobHisList = jobHisList;
    }

    public JobHistDA(String empNo) throws FileNotFoundException {
        Scanner jobHistFile = new Scanner(new FileReader("SE_Lab_Assignment_2/csv/JOBHISTFILE.csv"));

        // empty list of job history
        jobHisList = new ArrayList<>();

        while (jobHistFile.hasNext()) {
            String jobHistRow = new String();
            jobHistRow = jobHistFile.nextLine();
            String[] jobHistSpecific = new String[5];
            jobHistSpecific = jobHistRow.split(",");

            // job history object
            JobHistory jobHistory = new JobHistory();

            // set data of job history
            if (empNo.contentEquals(jobHistSpecific[0])) {
                jobHistory.setSalary(Double.parseDouble(jobHistSpecific[3]));
                jobHistory.setEffectiveDate(jobHistSpecific[2]);
                // insert job object
                JobDA jobDA = new JobDA(jobHistSpecific[1]);
                jobHistory.setJob(jobDA.getJobList());

                // insert department object
                DepartmentDA departmentDA = new DepartmentDA(jobHistSpecific[4]);
                jobHistory.setDepartment(departmentDA.getDepartmentList());

                // add job history object to job history list
                jobHisList.add(jobHistory);
            }
        }
    }
}
