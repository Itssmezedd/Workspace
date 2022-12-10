package SE_Lab_Assignment_2_3.HopeTechServ;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import SE_Lab_Assignment_2_3.HopeDomain.Job;

public class JobDA {
    List<Job> jobList;

    public List<Job> getJobList() {
        return jobList;
    }

    public void setJobList(List<Job> jobList) {
        this.jobList = jobList;
    }

    public JobDA(String jobCode) throws FileNotFoundException {
        Scanner jobFile = new Scanner(new FileReader("SE_Lab_Assignment_2/csv/JOBFILE.csv"));

        // empty list of job
        jobList = new ArrayList<>();

        while (jobFile.hasNext()) {
            String jobRow = new String();
            jobRow = jobFile.nextLine();
            String[] jobSpecific = new String[2];
            jobSpecific = jobRow.split(",");

            // job object
            Job job = new Job();

            // set data of job
            if (jobCode.contentEquals(jobSpecific[0])) {
                job.setDescription(jobSpecific[1]);

                // add job in jobList
                jobList.add(job);
            }

        }
    }
}
