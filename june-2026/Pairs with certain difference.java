// Pairs with certain difference

class Solution {
    public int sumDiffPairs(int[] arr, int k) {
        // Step 1: Sort the array to easily find close elements
        Arrays.sort(arr);
        
        int maxSum = 0;
        int i = arr.length - 1; // Start from the largest element
        
        // Step 2: Iterate backwards to greedily pick larger elements
        while (i > 0) {
            // Check if the adjacent elements satisfy the condition
            if (arr[i] - arr[i-1] < k) {
                maxSum += arr[i] + arr[i-1];
                i -= 2; // Move past both elements since pairs must be disjoint
            } else {
                i--; // Move to the next element
            }
        }
        
        return maxSum;
    }
}