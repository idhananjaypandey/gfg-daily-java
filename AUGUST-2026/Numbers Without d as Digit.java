// Numbers Without d as Digit

class Solution {
    public int countWithout(int n, int d) {
        if (n <= 0) return 0;

        String s = String.valueOf(n);
        int len = s.length();
        int count = 0;

        // 1. Numbers with fewer digits than n
        int firstDigitChoices = (d == 0) ? 9 : 8;
        for (int i = 1; i < len; i++) {
            count += firstDigitChoices * (int) Math.pow(9, i - 1);
        }

        // 2. Numbers with the same length as n
        boolean flag = true;
        for (int i = 0; i < len; i++) {
            int digit = s.charAt(i) - '0';
            int remainingDigits = len - 1 - i;

            for (int x = (i == 0 ? 1 : 0); x < digit; x++) {
                if (x != d) {
                    count += (int) Math.pow(9, remainingDigits);
                }
            }

            if (digit == d) {
                flag = false;
                break;
            }
        }

        if (flag) {
            count++;
        }

        return count;
    }
}