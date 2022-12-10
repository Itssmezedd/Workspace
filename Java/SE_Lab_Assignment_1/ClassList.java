package SE_Lab_Assignment_1;

import java.util.ArrayList;
import java.util.List;

public class ClassList {
   public static void main(String[] args) {

      Student student = new Student();
      student.setStudentNo("1234");
      student.setLastName("Dela Cruz");
      student.setFirstName("Juan");
      student.setGender("M");
      student.setProgram("BSCS");

      List<Course> courseList = new ArrayList<Course>();
      Course course1 = new Course();
      course1.setCourseCode("CSL311-18");
      course1.setDescription("SoftEng 1 lab");
      course1.setUnit(1);

      Course course2 = new Course();
      course2.setCourseCode("CSL311-18");
      course2.setDescription("SoftEng 1 lec");
      course2.setUnit(2);

      Course course3 = new Course();
      course3.setCourseCode("CSL211-18");
      course3.setDescription("Info Management 1");
      course3.setUnit(3);

      courseList.add(course1);
      courseList.add(course2);
      courseList.add(course3);
      student.setCoursesTaken(courseList);

      System.out.println(student);
    
   }
}
