package BloodType_Data;
import java.util.*;
public class RunBloodData{
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.print("Enter blood type of patient: ");
        String bt = in.nextLine();
        System.out.print("Enter the Rhesus factor (+ or -):");
        String rh = in.nextLine();
        if(bt.equalsIgnoreCase("o") || bt.equalsIgnoreCase("a") ||bt.equalsIgnoreCase("b") || bt.equalsIgnoreCase("ab")){
            if(rh.equalsIgnoreCase("+") ||rh.equalsIgnoreCase("-")){
                BloodData bd = new BloodData(bt,rh);
                bd.display(bd);
            }
        }
        else{
            BloodData db = new BloodData();
            db.display(db);
        }
        in.close();
    }
}