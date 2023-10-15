package main.java.org.polytech.first;

import java.util.Map;

public class RomanNumberConverter {

    private static final Map<Character, Integer> values = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000
    );

    public int convertToInt(String romanNumber) {
        int sum = 0;
        int previousNumber = 0;
        for (int i = romanNumber.length() - 1; i >= 0; i--) {
            Integer valueOfSymbol = values.get(romanNumber.charAt(i));
            if (valueOfSymbol == null) {
                return 0;
            }

            if (valueOfSymbol < previousNumber) {
                sum -= valueOfSymbol;
            } else {
                sum += valueOfSymbol;
                previousNumber = valueOfSymbol;
            }
        }

        return sum;
    }

}
