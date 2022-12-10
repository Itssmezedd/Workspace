package Activity2;

import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

class Student {
    String id;
    String lastname, firstname, degree;
    LinkedList<Address> address;
    LinkedList<Parent> parent;

    Student(String id, String lastname, String firstname,
            LinkedList<Address> address, LinkedList<Parent> parent, String degree) {
        setID(id);
        setLastname(lastname);
        setFirstname(firstname);
        setAddress(address);
        setParent(parent);
        setDegree(degree);
    }

    public String getID() {
        return "Student id is " + this.id;
    }

    public void setID(String id) {
        this.id = id;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getFullname() {
        return "Student name is " + getLastname() + ", " + getFirstname();
    }

    public LinkedList<Address> getAddress() {
        return this.address;
    }

    public void setAddress(LinkedList<Address> address) {
        this.address = address;
    }

    public LinkedList<Parent> getParent() {
        return this.parent;
    }

    public void setParent(LinkedList<Parent> parent) {
        this.parent = parent;
    }

    public String getDegree() {
        return this.degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }
}

class Address {
    String code, location;

    Address(String code, String location) {
        setCode(code);
        setLocation(location);
    }

    public String getAddress() {
        return getCode() + getLocation();
    }

    public String getCode() {
        if (this.code.equals("C")) {
            return "City Address is ";
        } else if (this.code.equals("P")) {
            return "Provincial Address is ";
        }
        return null;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

class Parent {
    String parentCode;
    String parentName;

    Parent(String parentCode, String parentName) {
        set_parentCode(parentCode);
        setParent(parentName);
    }

    public String get_parentCode() {
        if (this.parentCode.equals("G")) {
            return "Guardian's name is ";
        } else if (this.parentCode.equals("M")) {
            return "Mother's name is ";
        } else if (this.parentCode.equals("F")) {
            return "Father's name is ";
        }
        return null;
    }

    public void set_parentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getParent() {
        return get_parentCode() + this.parentName;
    }

    public void setParent(String parentName) {
        this.parentName = parentName;
    }
}

class Degree {
    String degreeCode;

    Degree(String degreeCode) {
        if (degreeCode.equals("BSCS")) {
            set_degreeCode("BS Computer Science");
        } else if (degreeCode.equals("BSIE")) {
            set_degreeCode("BS Industrial Engineering");
        } else if (degreeCode.equals("BSCE")) {
            set_degreeCode("BS Civil Engineering");
        } else if (degreeCode.equals("BSECE")) {
            set_degreeCode("BS Electronics Engineering");
        }
    }

    public String get_degreeCode() {
        return "Studying " + this.degreeCode;
    }

    public void set_degreeCode(String degreeCode) {
        this.degreeCode = degreeCode;
    }
}

public class StudentReport {
    static LinkedList<Address> processAddress(String[] rowStudentSpecific) throws Exception {
        Scanner addressFile = new Scanner(
                new File("C:/Users/jhncd/OneDrive/Desktop/Tools/Workspace/Java/Activity2/AddressInfo.csv"));
        LinkedList<Address> addressList = new LinkedList<Address>();
        while (addressFile.hasNext()) {
            String rowAddress = "";
            rowAddress += addressFile.nextLine();
            String[] rowAddressSpecific = rowAddress.split(",");
            if (rowStudentSpecific[0].equals(rowAddressSpecific[0])) {
                Address newAddress = new Address(rowAddressSpecific[1], rowAddressSpecific[2]);
                addressList.add(newAddress);
            }
        }
        addressFile.close();
        return addressList;
    }

    static LinkedList<Parent> processParent(String[] rowStudentSpecific) throws Exception {
        Scanner parentFile = new Scanner(
                new File("C:/Users/jhncd/OneDrive/Desktop/Tools/Workspace/Java/Activity2/ParentInfo.csv"));
        LinkedList<Parent> parentList = new LinkedList<Parent>();
        while (parentFile.hasNext()) {
            String rowParent = "";
            rowParent += parentFile.nextLine();
            String[] rowParentSpecific = rowParent.split(",");
            if (rowStudentSpecific[0].equals(rowParentSpecific[0])) {
                Parent newParent = new Parent(rowParentSpecific[1], rowParentSpecific[2]);
                parentList.add(newParent);
            }
        }
        parentFile.close();
        return parentList;
    }

    public static void main(String[] args) throws Exception {
        LinkedList<Student> studentList = new LinkedList<Student>();
        Scanner studFile = new Scanner(
                new File("C:/Users/jhncd/OneDrive/Desktop/Tools/Workspace/Java/Activity2/StudInfo.csv"));
        while (studFile.hasNext()) {
            String rowStudent = "";
            rowStudent += studFile.next();
            String[] rowStudentSpecific = rowStudent.split(",");
            Degree newDegree = new Degree(rowStudentSpecific[3]);
            Student newStudent = new Student(rowStudentSpecific[0], rowStudentSpecific[1], rowStudentSpecific[2],
                    processAddress(rowStudentSpecific), processParent(rowStudentSpecific),
                    newDegree.get_degreeCode());
            studentList.add(newStudent);
        }
        studFile.close();

        for (Student student : studentList) {
            System.out.println(student.getID());
            System.out.println(student.getFullname());
            System.out.println(student.getDegree());
            for (Address adress : student.getAddress()) {
                System.out.println(adress.getAddress());
            }
            for (Parent parent : student.getParent()) {
                System.out.println(parent.getParent());
            }
            System.out.println();
        }

    }
}
