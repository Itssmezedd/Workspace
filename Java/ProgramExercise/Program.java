package ProgramExercise;

import java.util.Scanner;

public class Program {
    static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {

                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    static String binarySearch(int[] arr, int first, int last, int search) {

        if (first > last) {
            return "\nUnsuccessful Search because (first > last) \n" + search + " not found\n";
        }
        int mid = (first + last) / 2;
        if (search < arr[mid]) {
            last = mid - 1;
            return binarySearch(arr, first, last, search);
        } else if (search > arr[mid]) {
            first = mid + 1;
            return binarySearch(arr, first, last, search);
        } else if (search == arr[mid]) {
            return "\nSuccessful Search, number " + search + " is at index " + mid + "\n";
        }

        return "";
    }

    static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("||Create Unsorted or Sorted List|| ");
        System.out.print("Enter array size: ");
        int size = input.nextInt();
        int[] arr = new int[size];
        System.out.print("Enter elements: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = input.nextInt();
        }
        if (isSorted(arr)) {
            System.out.print("Search: ");
            int search = input.nextInt();
            String result = binarySearch(arr, 0, arr.length - 1, search);
            System.out.println(result);
        }
        if (!isSorted(arr)) {
            System.out.println("\n||Sorting it using Selection Sort||");
            sort(arr);
            System.out.print("Sorted Array: ");
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
        System.out.print("Search: ");
        int search = input.nextInt();
        String result = binarySearch(arr, 0, arr.length - 1, search);
        System.out.println(result);
        input.close();
    }
}