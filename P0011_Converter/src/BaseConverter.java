
import java.math.BigInteger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrator
 */
public class BaseConverter {

    public static String processConversion(int baseIn, int baseOut, String value) {
        String result = "";
        // result stay the same if base in = base out 
        if (baseIn == baseOut) {
            return value;
        }
        // baseIn = 10, baseOut is either 2 or 16
        if (baseIn == 10) {
            result = convertFromDecimal(value, baseOut);
        } // baseOut = 10, baseIn is either 2 or 16
        else if (baseOut == 10) {
            result = convertToDecimal(value, baseIn);
        } // baseIn is either 2 or 16, likewise baseOut
        else {
            if (baseIn == 2) {
                result = biToHex(value);
            } else {
                result = hexToBi(value);
            }
        }
        return result;

    }

    private static String convertFromDecimal(String value, int base) {
        String symbols = "0123456789ABCDEF";
        BigInteger bigInt = new BigInteger(value);
        StringBuilder result = new StringBuilder("");

        // iterate as long as value is positive
        while (bigInt.compareTo(new BigInteger("0")) > 0) {
            int remainder = Integer.parseInt(bigInt.mod(new BigInteger(String.valueOf(base))).toString());
            BigInteger quotient = bigInt.divide(new BigInteger(String.valueOf(base)));

            result = result.append(symbols.charAt(remainder));

            System.out.println(bigInt + " : " + base + " = " + quotient + " remainder " + remainder);

            bigInt = bigInt.divide(new BigInteger(String.valueOf(base)));

        }
        return result.reverse().toString();
    }

    private static String convertToDecimal(String value, int base) {
        String symbols = "0123456789ABCDEF";
        BigInteger result = new BigInteger("0");

        // traverse from beginning to end of input value string
        for (int i = 0; i < value.length(); i++) {
            char ch = value.charAt(i);
            int num = symbols.indexOf(ch);
            int idx = value.length() - i - 1;
            BigInteger bi1 = new BigInteger(Integer.toString(num));
            BigInteger bi2 = new BigInteger(String.valueOf(base));

            result = (result.multiply(bi2)).add(bi1);

            // print out calculation process
            if (i == value.length() - 1) {
                System.out.print(num + "*" + base + "^" + idx + " = " + result);
            } else {
                System.out.print(num + "*" + base + "^" + idx + " + ");
            }
        }
        System.out.println();
        return result.toString();
    }

    private static String biToHex(String binary) {
        String symbols = "0123456789ABCDEF";
        String hexStr = "";
        StringBuilder str = new StringBuilder(binary);
        binary = str.reverse().toString();

        // traverse through binary string with step 4
        for (int i = 0; i < binary.length(); i += 4) {
            int end = i + 4;
            String subStr = "";
            // case 1: take out substring from binary string with length can't dividable by 4 (e.g 011)
            if (end <= binary.length()) {
                subStr = binary.substring(i, end);
            } // case 2: take out substring from binary string with length dividable by 4
            else {
                subStr = binary.substring(i, binary.length());
            }
            String binString = "01";

            int idx = 0;
            // traverse in reverse order through subStrstring 
            for (int j = subStr.length() - 1; j >= 0; j--) {
                int n = binString.indexOf(subStr.charAt(j));
                idx = idx * 2 + n;
            }
            hexStr += symbols.charAt(idx);
        }

        StringBuilder result = new StringBuilder(hexStr);
        return result.reverse().toString();
    }

    private static String hexToBi(String hexa) {
        String hexString = "0123456789ABCDEF";
        hexa = hexa.toUpperCase();
        String binaryStr = "";
        int length = 0;

        for (int i = hexa.length() - 1; i >= 0; i--) {
            char ch = hexa.charAt(i);
            int newNum = hexString.indexOf(ch);

            // hexa symbol = 0 => convert to binary subStrstring is 0000
            if (newNum == 0) {
                binaryStr += "0000";
            } else {
                // constantly divide newNum to 2 and add remander to binary string
                while (newNum != 0) {
                    int remainder = newNum % 2;
                    binaryStr += Integer.toString(remainder);
                    newNum = newNum / 2;
                }
                length = binaryStr.length();

                // if converted binary string length not dividable by 4, add complementary 0
                while (length % 4 != 0) {
                    binaryStr += Integer.toString(0);
                    length++;
                }
            }
        }
        StringBuilder result = new StringBuilder(binaryStr);
        return result.reverse().toString();
    }

}
