
import models.Person;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrator
 */
public class PersonManager {

    public void inputPersonInfo(Person[] person) {
        System.out.println("=====Management Person programer=====");

        for (int i = 0; i < person.length; i++) {
            System.out.println("Input Information of Person");
            // accept letters and spaces only
            String name = InputData.getString("Please input name:", "Name not valid!",
                    "^[a-zA-Z ]+$");
            // accept letters and spaces only
            String address = InputData.getString("Please input address:", "Address not valid!",
                    "^[a-zA-Z ]+$");
            double salary = InputData.getDouble("Please input salary:", "Salary is greater than zero");

            person[i] = new Person(name, address, salary);
        }
    }

    public void sortBySalary(Person[] person) {
        // traverse elements from the beginning to end of array
        for (int i = 0; i < person.length; i++) {
            // traverse from the beginning of array to the last unsorted element
            for (int j = 0; j < person.length - i - 1; j++) {
                // if current element's salary is greater than the next
                // then swap elements' position
                if (person[j].getSalary() > person[j + 1].getSalary()) {
                    Person temp = person[j];
                    person[j] = person[j + 1];
                    person[j + 1] = temp;
                }
            }
        }
    }

    public void displayPersonInfo(Person[] person) {
        for (int i = 0; i < person.length; i++) {
            person[i].display();
            
        }
    }

}
