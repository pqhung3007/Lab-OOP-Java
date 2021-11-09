/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
public class Main {

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        // loop until user chooses to exit
        while (true) {
            // Step 1: Display a menu
            displayMenu();

            // Step 2: Ask user to select an option
            int choice = InputData.getChoice("Your choice:", "Choice out of range [1-4]");
            switch (choice) {
            // Step 3: add 2 matrices
            case 1:
                calc.additionMatrix();
                break;
            // Step 4: subtract 2 matrices
            case 2:
                calc.subtractionMatrix();
                break;
            // Step 5: multiply 2 matrices
            case 3:
                calc.multiplicationMatrix();
                break;
            // Step 6: exit program
            case 4:
                System.exit(0);
            }
        }
    }

    private static void displayMenu() {
        System.out.println("=======Calculator program=======");
        System.out.println("1. Addition Matrix");
        System.out.println("2. Subtraction Matrix");
        System.out.println("3. Multiplication Matrix");
        System.out.println("4. Quit");
    }

}
