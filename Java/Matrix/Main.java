package Matrix;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int num, stored_num, squared;
    int col;
    System.out.print("Enter number: ");
    num = input.nextInt();
    stored_num = num;
    squared = num * num;

    // if greater than 1
    if (num > 1) {
      // if entered num is even
      if (num % 2 == 0) {

        for (; num >= 1; num--) {
          // if the row even
          if (num % 2 == 0) {
            for (int i = stored_num; i >= 1; i--, squared--) {
              System.out.print(squared + "\t");
            }
          }
          // if the row odd
          else {
            for (col = stored_num, squared -= (stored_num - 1); col >= 1; col--, squared++) {
              System.out.print(squared + "\t");
            }
            squared -= (stored_num + 1);
          }
          System.out.println();
        }
      }


      // if entered num is odd
      else {
        for (; num >= 1; num--) {
          // if row odd
          if (num % 2 == 1) {
            for (col = stored_num, squared -= (stored_num - 1); col >= 1; col--, squared++) {
              System.out.print(squared + "\t");
            }
            squared -= (stored_num + 1);
          }
          // if row even
          else {
            for (int i = stored_num; i >= 1; i--, squared--) {
              System.out.print(squared + "\t");
            }
          }
          System.out.println();
        }
      }
    }else{
      System.out.println("1");
    }

  }
}