// Bird and Max Fruit Gathering

class Solution {
    public int maxFruits(ArrayList<Integer> arr, int m) {
        int n = arr.size();
        int k = Math.min(m, n);
        
        int currentSum = 0;
        for (int i = 0; i < k; i++) {
            currentSum += arr.get(i);
        }
        
        int maxSum = currentSum;
        
        for (int i = 0; i < n; i++) {
            currentSum = currentSum - arr.get(i) + arr.get((i + k) % n);
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }
}