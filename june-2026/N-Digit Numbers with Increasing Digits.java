//  N-Digit Numbers with Increasing Digits

class Solution {
    public ArrayList<Integer> increasingNumbers(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        
        if (n == 1) {
            for (int i = 0; i <= 9; i++) {
                result.add(i);
            }
            return result;
        }
        
        if (n > 9) {
            return result;
        }
        
        generateNumbers(n, 0, 1, result);
        return result;
    }
    
    private void generateNumbers(int n, int currentNum, int startDigit, ArrayList<Integer> result) {
        if (n == 0) {
            result.add(currentNum);
            return;
        }
        
        for (int i = startDigit; i <= 9; i++) {
            generateNumbers(n - 1, currentNum * 10 + i, i + 1, result);
        }
    }
}