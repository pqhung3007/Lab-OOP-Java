
import java.util.ArrayList;
import models.Employee;

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
        EmployeeManager manager = new EmployeeManager();
        ArrayList<Employee> empList = new ArrayList<>();
        while (true) {
            // Step 1: display menu of choices
            manager.displayMenu();
            // Step 2: Ask user to make a choice
            int option = InputData.getOption("Enter your option: ", "Choice must be in range [1,6]", 1, 6, null);
            switch (option) {
                // Step 3: add new employee
                case 1:
                    manager.addEmployee(empList);
                    break;
                // Step 4: update an employee's info by their ID
                case 2:
                    manager.updateEmployeeById(empList);
                    break;
                // Step 5: remove an employee by their ID
                case 3:
                    manager.removeEmployeeById(empList);
                    break;
                // Step 6: find employee by name
                case 4:
                    manager.findEmployeeByName(empList);
                    break;
                // Step 7: sort employee by salary
                case 5:
                    manager.sortEmployeeBySalary(empList);
                    break;
                // Step 8: exit program
                case 6:
                    System.exit(0);

            }
        }
    }

    
}
