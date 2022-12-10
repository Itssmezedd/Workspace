package ReverseNum;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int num;
        Scanner input = new Scanner(System.in);
        num = input.nextInt();
        input.close();

        int reverseNum = 0;
        for (; num != 0; num = num / 10) {
            reverseNum = reverseNum * 10;
            reverseNum = reverseNum + (num % 10);
        }
        System.out.println(reverseNum);

    }
   
}
