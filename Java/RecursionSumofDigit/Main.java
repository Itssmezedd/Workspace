package RecursionSumofDigit;
import java.util.Scanner;

public class Main{
    public static int reverseNum =0;
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int inputNum, result=0;
        System.out.print("Enter num: ");
        inputNum=input.nextInt();
        input.close();

        System.out.print("Sum of Digits ");
        System.out.println("\nSum "+sum(reverse(inputNum), result));

    }

    static int sum(int num, int result){
        result=result+num%10;

        if (num<10 && num > 0){
            System.out.print(num%10);
            num=num/10;
            return sum(num, result);
        }
     
        if(num!=0){
            System.out.print(num%10 + "+");
            num=num/10;
            return sum(num, result);
        }
        else{
            return result;
        }
    }

    static int reverse(int num){
        if(num!=0){
            reverseNum = reverseNum * 10;
            reverseNum = reverseNum + (num % 10);
            num=num/10;
            return reverse(num);
        }
        else{
            return reverseNum;
        }
    }
}