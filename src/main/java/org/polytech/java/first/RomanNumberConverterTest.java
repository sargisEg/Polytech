package main.java.org.polytech.java.first;

public class RomanNumberConverterTest {

    public static void main(String[] args) {
        RomanNumberConverter romanNumberConverter = new RomanNumberConverter();
        System.out.println(romanNumberConverter.convertToInt("MMMCMXCIX"));
        System.out.println(romanNumberConverter.convertToInt("III"));
        System.out.println(romanNumberConverter.convertToInt("LVIII"));
        System.out.println(romanNumberConverter.convertToInt("MCMXCIV"));
        System.out.println(romanNumberConverter.convertToInt("MDLX"));
    }
}
