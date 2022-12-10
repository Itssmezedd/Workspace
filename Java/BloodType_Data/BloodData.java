package BloodType_Data;
class BloodData {
    static String bloodType;
    static String rhFactor;
    public BloodData (){
        
        bloodType = "O";
        rhFactor = "+";
    }

    public BloodData (String bt, String rh){
        bloodType = bt;
        rhFactor =rh;
    }

    public void display(BloodData br){
        System.out.println(BloodData.bloodType + BloodData.rhFactor + " is added to the blood bank");
    }
}    