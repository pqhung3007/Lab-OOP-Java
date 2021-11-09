/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
public class Calculator {

    public void additionMatrix() {
        System.out.println("-------Addition-------");

        int row1 = InputData.getMatrixSize("Enter Row Matrix 1:");
        int col1 = InputData.getMatrixSize("Enter Column Matrix 1:");
        int[][] matrix1 = InputData.getMatrixValue(row1, col1, 1);

        int row2 = 0, col2 = 0;
        while (true) {
            row2 = InputData.getMatrixSize("Enter Row Matrix 2:");
            // ensure row of each matrix must be the same
            if (row2 != row1) {
                System.out.println("Number of rows of both matrices must be the same");
                continue;
            }
            break;
        }
        while (true) {
            col2 = InputData.getMatrixSize("Enter Column Matrix 2:");
            // ensure column of each matrix must be the same
            if (col2 != col1) {
                System.out.println("Number of columns of both matrices must be the same");
                continue;
            }
            break;
        }
        int[][] matrix2 = InputData.getMatrixValue(row2, col2, 2);

        int[][] sum = processAddition(matrix1, matrix2);
        displayExpression(matrix1, "+", matrix2, sum);
    }

    public int[][] processAddition(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int cols = matrix1[0].length;
        int[][] result = new int[rows][cols];
        // traverse through matrix1's row 
        for (int i = 0; i < rows; i++) {
            // traverse through matrix1's column
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }

    public void substractionMatrix() {
        System.out.println("-------Subtraction-------");

        int row1 = InputData.getMatrixSize("Enter Row Matrix 1:");
        int col1 = InputData.getMatrixSize("Enter Column Matrix 1:");
        int[][] matrix1 = InputData.getMatrixValue(row1, col1, 1);

        int row2 = 0, col2 = 0;
        while (true) {
            row2 = InputData.getMatrixSize("Enter Row Matrix 2:");
            // ensure rows of each matrix must be the same
            if (row2 != row1) {
                System.out.println("Number of rows of both matrices must be the same");
                continue;
            }
            break;
        }
        while (true) {
            col2 = InputData.getMatrixSize("Enter Column Matrix 2:");
            // ensure columns of each matrix must be the same
            if (col2 != col1) {
                System.out.println("Number of columns of both matrices must be the same");
                continue;
            }
            break;
        }
        int[][] matrix2 = InputData.getMatrixValue(row2, col2, 2);

        int[][] difference = processSubstraction(matrix1, matrix2);
        displayExpression(matrix1, "-", matrix2, difference);
    }

    public int[][] processSubstraction(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int cols = matrix1[0].length;
        int[][] result = new int[rows][cols];
        // traverse through matrix1's row 
        for (int i = 0; i < rows; i++) {
            // traverse through matrix1's column
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }

        }
        return result;
    }

    public void multiplicationMatrix() {
        System.out.println("-------Multiplication-------");

        int row1 = InputData.getMatrixSize("Enter Row Matrix 1:");
        int col1 = InputData.getMatrixSize("Enter Column Matrix 1:");
        int[][] matrix1 = InputData.getMatrixValue(row1, col1, 1);

        int row2 = 0, col2 = 0;
        while (true) {
            row2 = InputData.getMatrixSize("Enter Row Matrix 2:");
            // ensure column of matrix 1 = row of matrix 2
            if (row2 != col1) {
                System.out.println("Number of columns in matrix 1 must equal number of rows in matrix 2");
                continue;
            }
            col2 = InputData.getMatrixSize("Enter Column Matrix 2:");
            break;
        }
        int[][] matrix2 = InputData.getMatrixValue(row2, col2, 2);

        int[][] product = processMultiplication(matrix1, matrix2);
        displayExpression(matrix1, "*", matrix2, product);
    }

    public int[][] processMultiplication(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int cols = matrix2[0].length;
        int k = matrix1[0].length;
        int[][] result = new int[rows][cols];
        // traverse through matrix1's row 
        for (int i = 0; i < rows; i++) {
            // traverse through matrix2's column
            for (int j = 0; j < cols; j++) {
                // traverse through matrix1's column
                for (int l = 0; l < k; l++) {
                    result[i][j] += matrix1[i][l] * matrix2[l][j];
                }
            }
        }
        return result;
    }

    public void displayExpression(int[][] matrix1, String operator, int[][] matrix2, int[][] result) {
        System.out.println("-------Result-------");
        displayMatrix(matrix1);
        System.out.println(operator);
        displayMatrix(matrix2);
        System.out.println("=");
        displayMatrix(result);
    }

    public void displayMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        // traverse through matrix's row
        for (int i = 0; i < rows; i++) {
            // traverse through matrix's column 
            for (int j = 0; j < cols; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println();
        }
    }

}
