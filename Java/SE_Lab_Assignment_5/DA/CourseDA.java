package SE_Lab_Assignment_5.DA;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import SE_Lab_Assignment_5.Domain.Course;

public class CourseDA {
    List<Course> courseList = new ArrayList<>();

    public List<Course> getCourseList() {
        return courseList;
    }

    public CourseDA(String studno) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("SE_Lab_Assignment_5/csv/scheduleInfo.csv"));
        String line;
        while ((line = br.readLine()) != null) {
            String[] specific = line.split(", ");

            if (studno.contentEquals(specific[0])) {
                Course course = new Course();
                course.setCourseCode(specific[1]);
                course.setDescription(specific[2]);
                course.setUnit(Integer.parseInt(specific[3]));
                course.setDay(specific[4]);
                course.setTime(specific[5]);

                courseList.add(course);
            }
        }
        br.close();
    }
}
