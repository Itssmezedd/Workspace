package SE_Lab_Assignment_5.DA;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import SE_Lab_Assignment_5.Domain.Student;

public class StudentDA {
    List<Student> studentList = new ArrayList<>();

    public List<Student> getStudentList() {
        return studentList;
    }

    public StudentDA() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("SE_Lab_Assignment_5/csv/studentInfo.csv"));
        String line;
        while ((line = br.readLine()) != null) {
            String[] specific = line.split(", ");

            Student student = new Student();

            student.setProgram(specific[0]);
            student.setStudentNumber(specific[1]);
            student.setName(specific[2]);

            CourseDA courseDA = new CourseDA(specific[1]);
            student.setCourseList(courseDA.getCourseList());

            studentList.add(student);
        }
        br.close();
    }

}
