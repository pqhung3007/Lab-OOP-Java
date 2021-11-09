/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
public class Display {

    public static void displayOutput(int baseIn, int baseOut, String valueIn, String valueOut) {
        System.out.println("=> " + valueIn + "(" + getBaseName(baseIn) + ")" + " = "
                + valueOut + "(" + getBaseName(baseOut) + ")");
    }

    private static String getBaseName(int base) {
        String baseName = "";
        switch (base) {
            case 2:
                baseName = "bin";
                break;
            case 10:
                baseName = "dec";
                break;
            case 16:
                baseName = "hex";
                break;
            default:
                break;
        }
        return baseName;
    }

}
