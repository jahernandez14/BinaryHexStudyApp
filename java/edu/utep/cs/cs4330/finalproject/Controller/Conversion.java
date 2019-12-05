package edu.utep.cs.cs4330.finalproject.Controller;

import java.util.*;
public class Conversion {
    static final HashMap<Character, String> hexMap = new HashMap<Character, String>();

    static {
        hexMap.put('0', "0000");
        hexMap.put('1', "0001");
        hexMap.put('2', "0010");
        hexMap.put('3', "0011");
        hexMap.put('4', "0100");
        hexMap.put('5', "0101");
        hexMap.put('6', "0110");
        hexMap.put('7', "0111");
        hexMap.put('8', "1000");
        hexMap.put('9', "1001");
        hexMap.put('A', "1010");
        hexMap.put('B', "1011");
        hexMap.put('C', "1100");
        hexMap.put('D', "1101");
        hexMap.put('E', "1110");
        hexMap.put('F', "1111");
    }

    private static boolean binaryChecker(char c) {
        return (c == '1' || c == '0');
    }

    private static boolean hexChecker(char c) {
        return hexMap.containsKey(Character.toUpperCase(c));
    }

    public static String easy(String num, boolean type) {
        if (type == true) {
            for (int i = 0; i < num.length(); i++) {
                if (!binaryChecker(num.charAt(i))) {
                    return "-1";
                }
            }
            if(!num.equals("")) {
                int decimalValue = Integer.parseInt(num, 2);
                return Integer.toString(decimalValue);
            }
        }

        if (type == false) {
            num = num.toUpperCase();
            String hexStr = "";
            for (int i = 0; i < num.length(); i++) {
                hexStr += hexMap.get(num.charAt(i));
                if (!hexChecker(num.charAt(i))) {
                    return "-1";

                }
            }
            if(!num.equals("")) {
                int decimalValue = Integer.parseInt(hexStr, 2);
                return Integer.toString(decimalValue);
            }
        }

        return "-1";
    }
}