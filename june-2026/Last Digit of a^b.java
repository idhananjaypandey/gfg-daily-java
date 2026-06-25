// Last Digit of a^b

class Solution {
    static int getLastDigit(String a, String b) {
        // If exponent is "0", anything^0 = 1
        if (b.equals("0")) {
            return 1;
        }
        
        // If base is "0", 0^anything = 0
        if (a.equals("0")) {
            return 0;
        }

        // 1. Get the last digit of base 'a'
        int base = a.charAt(a.length() - 1) - '0';

        // 2. Find b % 4 using its last two digits
        int exp = 0;
        if (b.length() == 1) {
            exp = b.charAt(0) - '0';
        } else {
            // Take the last two digits of string b
            exp = Integer.parseInt(b.substring(b.length() - 2));
        }

        // 3. Adjust exponent based on cyclicity of 4
        exp = exp % 4;
        if (exp == 0) {
            exp = 4;
        }

        // 4. Calculate the last digit
        int result = (int) Math.pow(base, exp);
        return result % 10;
    }
}