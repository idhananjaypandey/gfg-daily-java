// Max Digit Sum Number in 1 to n

class Solution {
    public int findMax(int n) {
        int maxNum = n;
        int maxSum = sumOfDigits(n);
        
        String s = String.valueOf(n);
        char[] digits = s.toCharArray();
        
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == '0') {
                continue;
            }
            
            digits[i]--;
            for (int j = i + 1; j < digits.length; j++) {
                digits[j] = '9';
            }
            
            int currentNum = Integer.parseInt(new String(digits));
            int currentSum = sumOfDigits(currentNum);
            
            if (currentSum > maxSum || (currentSum == maxSum && currentNum > maxNum)) {
                maxSum = currentSum;
                maxNum = currentNum;
            }
            
            digits = s.toCharArray();
        }
        
        return maxNum;
    }
    
    private int sumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}