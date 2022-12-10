package MainPackage.Student;

public class Studentinfo {
    String name;
    int age;
    String gender;
    String address;
    double contact;
    String father, mother;

    public void display_Student() {
        System.out.println("\n\nSTUDENT DETAILS:");
        System.out.println("Student Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Student Gender:" + getGender());
        System.out.println("Student Address:" + getAddress());
        System.out.println("Contact Number: " + getContact());
        System.out.println("Father's Name: " + getFather());
        System.out.println("Mother's Name: " + getMother());
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return this.gender;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return this.address;
    }

    public void setContact(double contact) {
        this.contact = contact;
    }

    public double getContact() {
        return this.contact;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public String getFather() {
        return this.father;
    }

    public void setMother(String mother) {
        this.mother = mother;
    }

    public String getMother() {
        return this.mother;
    }
}

class Acadinfo {

}
