
import models.Employee;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrator
 */
public class EmployeeManager {

    public void displayMenu() {
        System.out.println("1.	Add employees \n"
                + "2.	Update employees\n"
                + "3.	Remove employees\n"
                + "4.	Search employees\n"
                + "5.	Sort employees by salary\n"
                + "6.	Exit");
    }

    public void addEmployee(ArrayList<Employee> empList) {
        String id = "";
        while (true) {
            // ID must have 3 digits
            id = InputData.getString("Enter ID: ", "Invalid ID", "^(\\d{3})$", null);
            // when another employee with entered ID is found
            // => duplicated ID occured
            if (checkDuplicatedId(empList, id)) {
                System.out.println("This ID is duplicated.");
            } else {
                break;
            }
        }

        // first letter of first & last name must be capitalized, only accept letters
        String firstName = InputData.getString("Enter first name: ", "Invalid first name",
                "^[A-Z][a-zA-Z ]*$", null);
        String lastName = InputData.getString("Enter last name: ", "Invalid last name",
                "^[A-Z][a-zA-Z ]*$", null);
        // phone number must start with 0 and have 10 digits
        String phone = InputData.getString("Enter phone num: ", "Invalid phone num",
                "^0\\d{9}$", null);
        // email must have form abc@abc.com
        String email = InputData.getString("Enter email: ", "Invalid email",
                "^\\w*@(\\w+[.])*\\w+$", null);
        // address: only accept letters
        String add = InputData.getString("Enter address: ", "Invalid address",
                "^[a-zA-Z ]*$", null);
        // dob must match dd/mm/yyyy
        Date dob = InputData.getDate("Enter date of birth: ", "Invalid dob",
                "dd/MM/yyyy", null);
        // gender choice is M or F only
        String sex = InputData.getString("Enter sex (M/F): ", "Choose male (M) or female (F) only",
                "^(M|F)$", null);
        double salary = InputData.getDouble("Enter salary: ", "Salary must be > 0",
                null);
        // agency name: only accept letters
        String agency = InputData.getString("Enter agency: ", "Invalid agency",
                "^[a-zA-Z ]*$", null);

        empList.add(new Employee(id, firstName, lastName, phone, email, add, dob, sex, salary, agency));

        displayHeader();
        displayEmployee(empList);
        System.out.println("Add new employee successfully");
    }

    public void updateEmployeeById(ArrayList<Employee> empList) {
        if (empList.isEmpty()) {
            System.out.println("List empty");
            return;
        }
        String id = InputData.getString("Enter ID: ", "Invalid ID", "^(\\d{3})$", null);
        Employee employee = getEmployeeById(empList, id);

        // if employee object is found, require user to fill in each field
        if (employee != null) {
            while (true) {
                id = InputData.getString("Enter new ID: ", "Invalid ID", "^(\\d{3})$", null);
                // check if newly created ID duplicated available one
                if (checkDuplicatedId(empList, id) && !id.equals(employee.getId())) {
                    System.out.println("This ID is already used by another employee.");
                } else {
                    break;
                }
            }
            String firstName = InputData.getString("Enter new first name: ", "Invalid first name",
                    "^[A-Z][a-zA-Z ]*$", "");
            String lastName = InputData.getString("Enter new last name: ", "Invalid last name",
                    "^[A-Z][a-zA-Z ]*$", "");
            String phone = InputData.getString("Enter new phone num: ", "Invalid phone num",
                    "^0\\d{9}$", "");
            String email = InputData.getString("Enter new email: ", "Invalid email",
                    "^\\w*@(\\w+[.])*\\w+$", "");
            String add = InputData.getString("Enter new address: ", "Invalid address",
                    "^[a-zA-Z ]*$", "");
            Date dob = InputData.getDate("Enter new date of birth: ", "Invalid dob",
                    "dd/MM/yyyy", "");
            String sex = InputData.getString("Enter new sex: ", "Choose male or female only",
                    "^(M|F|m|f)$", "");
            Double salary = InputData.getDouble("Enter new salary: ", "Salary must be > 0",
                    "");
            String agency = InputData.getString("Enter new agency: ", "Invalid agency",
                    "^[a-zA-Z ]*$", "");

            // ensure new infos are set only if fields are not null
            if (id != null) {
                employee.setId(id);
            }
            if (firstName != null) {
                employee.setFirstName(firstName);
            }
            if (lastName != null) {
                employee.setLastName(lastName);
            }
            if (phone != null) {
                employee.setPhone(phone);
            }
            if (email != null) {
                employee.setEmail(email);
            }
            if (add != null) {
                employee.setAddress(add);
            }
            if (dob != null) {
                employee.setDob(dob);
            }
            if (sex != null) {
                employee.setSex(sex);
            }
            if (salary != null) {
                employee.setSalary(salary);
            }
            if (agency != null) {
                employee.setAgency(agency);
            }

            System.out.println("Update employee successfully!");
            displayHeader();
            displayEmployee(empList);
            // No employee found, display alert     
        } else {
            System.out.println("Cannot find employee. Modification failed");
        }
        System.out.println();
    }

    public void removeEmployeeById(ArrayList<Employee> empList) {
        if (empList.isEmpty()) {
            System.out.println("List empty");
            return;
        }

        String id = InputData.getString("Enter ID: ", "Invalid ID", "^(\\d{3})$", null);
        Employee employee = getEmployeeById(empList, id);

        // if employee is found, remove that employee
        if (employee != null) {
            empList.remove(employee);
            System.out.println("Successfully delete employee! List after deletion:");
            displayHeader();
            displayEmployee(empList);
        } else {
            System.out.println("Cannot find employee. Deletion failed");
        }
        System.out.println();
    }

    public void findEmployeeByName(ArrayList<Employee> empList) {
        if (empList.isEmpty()) {
            System.out.println("List empty");
            return;
        }
        String name = InputData.getString("Enter name: ", "Invalid name", "^[a-zA-Z ]+$", null);
        boolean isExisted = false;

        for (Employee e : empList) {
            // if input name match employee's name in list, display their info
            if (e.getFirstName().contains(name) || e.getLastName().contains(name)) {
                if (!isExisted) {
                    displayHeader();
                }
                isExisted = true;
                System.out.println(e);
            }
        }
        // no employee found, alert user
        if (!isExisted) {
            System.out.println("Employee not found");
        }
        System.out.println();
    }

    public void sortEmployeeBySalary(ArrayList<Employee> empList) {
        if (empList.isEmpty()) {
            System.out.println("List empty");
            return;
        }
        Collections.sort(empList, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return Double.compare(o1.getSalary(),o2.getSalary());
            }

        });
        displayHeader();
        displayEmployee(empList);
    }

    private void displayHeader() {
        System.out.format("%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-10s%-15s%-15s\n",
                "Id", "First name", "Last name", "Phone num", "Email", "Address", "DOB", "Sex", "Salary", "Agency");
    }

    private void displayEmployee(ArrayList<Employee> empList) {
        for (Employee e : empList) {
            System.out.println(e);
        }
    }

    private boolean checkDuplicatedId(ArrayList<Employee> empList, String id) {
        for (Employee e : empList) {
            if (e.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    private Employee getEmployeeById(ArrayList<Employee> empList, String id) {
        for (Employee e : empList) {
            if (e.getId().equals(id)) {
                return e;
            }
        }
        return null;
    }

}
