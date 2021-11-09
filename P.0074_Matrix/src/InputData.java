
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrator
 */
public class InputData {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int getChoice(String msg, String err) {
        // loop until if condition are met
        while (true) {
            try {
                System.out.print(msg);
                int choice;
                choice = Integer.parseInt(br.readLine());
                if (choice >= 1 && choice <= 4) {
                    return choice;
                } else {
                    System.out.println(err);
                }

            } catch (IOException | NumberFormatException ex) {
                System.out.println("You must enter a number");
            }
        }
    }

    public static int getMatrixSize(String msg) {
        while (true) {
            try {
                int size;
                System.out.print(msg);
                size = Integer.parseInt(br.readLine());
                if (size > 0) {
                    return size;
                } else {
                    System.out.println("Size of matrix must be > 0");
                }
            } catch (IOException | NumberFormatException ex) {
                System.out.println("You must enter a number");
            }
        }
    }

    public static int[][] getMatrixValue(int row, int col, int matrixNum) {
        int[][] matrix = new int[row][col];
        // traverse through matrix row
        for (int i = 0; i < row; i++) {
            // traverse through col  
            for (int j = 0; j < col; j++) {
                while (true) {
                    try {
                        System.out.print("Enter Matrix" + matrixNum + 
                                "[" + (i + 1) + "][" + (j + 1) + "]:");
                        matrix[i][j] = Integer.parseInt(br.readLine());
                        break;
                    } catch (IOException | NumberFormatException e) {
                        System.out.println("Values of matrix is digit");
                    }
                }
            }
        }
        return matrix;
    }

}
