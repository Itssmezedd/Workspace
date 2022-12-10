package Activity1;
import java.io.*;
import java.util.*;
public class StudentReport {
    public static void main(String[]args){
        List<Studinfo> studentsList=new ArrayList<Studinfo>();
        List<Parentinfo> parentsList=new ArrayList<Parentinfo>();
        List<Addressinfo> addressesList=new ArrayList<Addressinfo>();
        InputStreamReader converter = new InputStreamReader(System.in);
        BufferedReader studFile= new BufferedReader(converter);
        
        int studNumber;
        String studFirstname,studLastname,degreeCode,parentName,address;
        String parentCode,addressCode;
        for(int i=0;i<1;i++){
            try {
                System.out.print("student id: ");
                studNumber=Integer.parseInt(studFile.readLine());
                System.out.print("firstname: ");
                studFirstname= studFile.readLine();
                System.out.print("lastname: ");
                studLastname= studFile.readLine();
                System.out.print("degree code: ");
                degreeCode= studFile.readLine();
                System.out.print("parent code: ");
                parentCode= studFile.readLine();
                System.out.print("parent name: ");
                parentName= studFile.readLine();
                System.out.print("address code: ");
                addressCode= studFile.readLine();
                System.out.print("address: ");
                address= studFile.readLine();
                System.out.println();
            
                Studinfo newStudent=new Studinfo(studNumber, studFirstname, studLastname, degreeCode);
                studentsList.add(newStudent);
                Parentinfo newParent=new Parentinfo(parentName, parentCode);
                parentsList.add(newParent);
                Addressinfo newAddress=new Addressinfo(addressCode, address);
                addressesList.add(newAddress);
            } catch (Exception e) {}
        }
        for(int i=0;i<studentsList.size();i++){
            Studinfo studentInfo=studentsList.get(i);
            Parentinfo parentInfo=parentsList.get(i);
            Addressinfo addressInfo=addressesList.get(i);
            System.out.println("Student id is "+studentInfo.getstudNumber());
            System.out.println("Student name is "+studentInfo.getLastname()+", "+studentInfo.getFirstname());
            System.out.println("Studying "+studentInfo.getDegreeCode());
            String temp1=addressInfo.getAddressCode();
            if(temp1.equals("C")||temp1.equals("c")){
                System.out.println("City address is "+addressInfo.getAddress());
            }
            else{
                System.out.println("Provincial address is "+addressInfo.getAddress());
            }
            String temp2=parentInfo.getparentCode();
            switch(temp2){
                case "M":
                case "m":
                    System.out.println("Father's name is "+parentInfo.getparentName());
                    break;
                case "F":
                case "f":
                    System.out.println("Mother's name is "+parentInfo.getparentName());
                    break;
                case "G":
                case "g":
                    System.out.println("Guardian's name is "+parentInfo.getparentName());
                    break;
            }
          
        }
    }    
}


class Studinfo{
    private int studNumber;
    private String studFirstname;
    private String studLastname;
    private String degreeCode;

    public Studinfo(int studNumber,String studFirstname, String studLastname,String degreeCode){
        setstudNumber(studNumber);
        setFirstname(studFirstname);
        setLastname(studLastname);
        setDegreeCode(degreeCode);
    }

    // Setters and Getters (student number, firstname, lastname, degree code )

    public int getstudNumber(){
        return this.studNumber;
    }
    public void setstudNumber(int studNumber){
        this.studNumber=studNumber;
    }

    public String getFirstname(){
        return this.studFirstname;
    }
    public void setFirstname(String studFirstname){
        this.studFirstname=studFirstname;
    }

    public String getLastname(){
        return this.studLastname;
    }
    public void setLastname(String studLastname){
        this.studLastname=studLastname;
    }

    public String getDegreeCode(){
        return this.degreeCode;
    }
    public void setDegreeCode(String degreeCode){
        this.degreeCode=degreeCode;
    }
    
}

class Parentinfo{
    private String parentName;
    private String parentCode;

    public Parentinfo(String parentName, String parentCode){
        setparentName(parentName);
        setparentCode(parentCode);
    }

    // Setters and Getters (student number, parent name, parent code)
    public String getparentName(){
        return this.parentName;
    }
    public void setparentName(String parentName){
        this.parentName=parentName;
    }

    public String getparentCode(){
        return this.parentCode;
    }
    public void setparentCode(String parentCode){
        this.parentCode=parentCode;
    }
}

class Addressinfo{
    private String addressCode;
    private String address;

    public Addressinfo(String addressCode,String address){
        setAddressCode(addressCode);
        setAddress(address);
    }

    // Setters and Getters (address code, address)

    public String getAddressCode(){
        return addressCode;
    }
    public void setAddressCode(String addressCode){
        this.addressCode=addressCode;
    }

    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address=address;
    }

}