class Solution {
    public int maxPackages(int[] arr, int totalTime) {
        if (totalTime > arr.length) {
            totalTime = arr.length;
        }
        
        int currentSum = 0;
        for (int i = 0; i < totalTime; i++) {
            currentSum += arr[i];
        }
        
        int maxSum = currentSum;
        for (int i = totalTime; i < arr.length; i++) {
            currentSum += arr[i] - arr[i - totalTime];
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }
}