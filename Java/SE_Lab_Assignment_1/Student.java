package SE_Lab_Assignment_1;

import java.util.List;

public class Student {
	private String studentNo;
	private String lastName;
	private String firstName;
	private String gender;
	private String program;
	private List<Course> coursesTaken;

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
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

	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	public List<Course> getCoursesTaken() {
		return coursesTaken;
	}

	public void setCoursesTaken(List<Course> coursesTaken) {
		this.coursesTaken = coursesTaken;
	}

	public String toString() {
		String output = "";
		output += "Student number is " + studentNo;
		output += "\nName: " + lastName.toUpperCase() + ", " + firstName;
		output += "\nGender: " + gender;
		output += "\nProgram: " + program;

		output += "\n\nCourse Taken:\n";
		int size = 0;
		while (size < coursesTaken.size()) {
			output += "Course code: " + coursesTaken.get(size).getCourseCode();
			output += "\nDescription: " + coursesTaken.get(size).getDescription();
			output += "\nNumber of Units: " + coursesTaken.get(size).getUnit() + "\n\n";
			size++;
		}
		return output;
	}
}
