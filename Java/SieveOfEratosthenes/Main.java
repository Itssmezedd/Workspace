package SieveOfEratosthenes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static void getPrime() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number: ");
        int n = input.nextInt();
        input.close();

        // we make it n+1 cause we always start with 2
        // if we don't put +1 we'll gonna get out of bounds in index
        boolean[] isPrime = new boolean[n + 1];
        List<Integer> primeNum = new ArrayList<Integer>();

        // first we make all index from 2 to n of isPrime[] index
        // to true as default for now
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primeNum.add(i);
                for (int j = i; j * i <= n; j++) {
                    // make it false everytime it's not prime
                    // so every loop it'll now disregard the "false" part
                    // and just move into part of "true" then add it on list
                    isPrime[i * j] = false;
                }
            }
        }
        System.out.println("List of primes less than or equal to " + n);
        for (Integer integer : primeNum) {
            System.out.print(integer + " ");
        }
        System.out.println();
        System.out.println();
    }

    public static void main(String[] args) {
        getPrime();
    }
}
