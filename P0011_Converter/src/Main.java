

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
        boolean isRepeated;
        do {
            // Step 1: Choose base number input
            int baseIn = InputData.getBaseNumber("Choose input base", "Invalid input base");

            // Step 2: Choose base number output
            int baseOut = InputData.getBaseNumber("Choose output base", "Invalid output base");

            // Step 3: Enter input value
            String valueIn = InputData.getValue(baseIn);

            // Step 4: Process to convert input value
            String valueOut = BaseConverter.processConversion(baseIn, baseOut, valueIn);
            
            // Step 5: Display output result
            Display.displayOutput(baseIn, baseOut, valueIn, valueOut);
            
            // Step 6: Ask user if they want to repeat the process
            isRepeated = Validator.checkRepeat();
        } while (isRepeated);
    }

}
