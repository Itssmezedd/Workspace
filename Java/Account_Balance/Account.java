package Account_Balance;
public class Account {
    public static float Debit(float balance, float withdraw){
        float total;
        total = balance - withdraw;
        return total;
    }
}