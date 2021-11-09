/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p.pkg0001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Administrator
 */
public class Main {

    public static void main(String[] args) {
        // Step 1: Input a postive decimal integer
        int decimal = inputPositiveDecimal();

        // Step 2: Generate random array
        int[] arr = new int[decimal];
        randArray(arr);

        // create sample array to test algorithm (specific lecturer's requirement)
        // int[] arr = createSampleArray();

        // Step 3: Display array before sorting
        displayArray("Unsorted array: ", arr);

        // Step 4: Implement bubble sort
        int[] sortArray = bubbleSort(arr);

        // Step 5: Display array after sorting
        displayArray("Sorted array: ", sortArray);

    }

    // input positive int (array size)
    private static int inputPositiveDecimal() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.println("Enter number of array: ");
                int num;
                num = Integer.parseInt(br.readLine());
                if (num > 0) {
                    return num;
                } else {
                    System.out.println("Number must be greater than 0");
                }
            } catch (IOException | NumberFormatException e) {
                System.out.println("You must enter a number in correct format!");
            }
        }
    }

    // randomize array elements with value within number range
    private static int[] randArray(int[] arr) {
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(arr.length);
        }
        return arr;
    }

    // private static int[] createSampleArray() {
    // int temp[] = new int[]{5, 1, 18, -5, 16};
    // return temp;
    // }

    // display array
    private static void displayArray(String msg, int[] arr) {
        System.out.print(msg);
        System.out.print(Arrays.toString(arr));
    }

    // perform bubble sort
    private static int[] bubbleSort(int[] arr) {
        System.out.println("");
        // traverse elements from the beginning to the end of array
        for (int i = 0; i < arr.length - 1; i++) {
            // traverse from the beginning of array to last unsorted element
            for (int j = 0; j < arr.length - i - 1; j++) {
                // check if current number is greater than the next
                // if yes then swap its position
                if (arr[j] > arr[j + 1]) {
                    // System.out.println(Arrays.toString(arr) + "\t" + arr[j] + " > " + arr[j + 1]
                    // + ",swap");
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                } else {
                    // System.out.println(Arrays.toString(arr) + "\t" + arr[j] + " < " + arr[j + 1]
                    // + ",ok");

                }
            }
            System.out.println();
        }
        return arr;
    }

}
