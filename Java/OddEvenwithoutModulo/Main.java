package OddEvenwithoutModulo;
import java.util.*;

public class Main {
    public static void main (String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n;
        System.out.println("Enter the number :");
        n = input.nextInt();
        input.close();
        if(isEven(n))
             System.out.print("Even\n");
        else
            System.out.print("Odd\n");
        }
    static boolean isEven(int n)
    {
        return ((n / 2) * 2 == n);
    }

}


