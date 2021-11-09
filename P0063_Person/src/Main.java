
import models.Person;

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
        PersonManager manager = new PersonManager();
        Person[] person = new Person[3];

        // Step 1: Prompt user to input data of 3 persons
        manager.inputPersonInfo(person);
        
        // Step 2: Sort person by salary (ascending)
        manager.sortBySalary(person);

        // Step 3: Display their info after sort
        manager.displayPersonInfo(person);
    }

}
