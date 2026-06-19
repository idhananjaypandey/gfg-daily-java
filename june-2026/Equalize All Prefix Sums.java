// Equalize All Prefix Sums

class Solution {
    public ArrayList<Integer> optimalArray(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>(n);
        
        long leftSum = 0;
        long rightSum = 0;
        
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                result.add(0);
            } else if (i % 2 != 0) {
                // When i is odd, the subarray size (i + 1) is even.
                // The new element goes to the right half, and the middle element shifts to the left half.
                rightSum += arr[i];
                leftSum += arr[i / 2];
                result.add((int) (rightSum - leftSum));
            } else {
                // When i is even, the subarray size (i + 1) is odd.
                // The new element is added to the right half, but the previous median element is excluded from the right half.
                rightSum += arr[i] - arr[i / 2];
                result.add((int) (rightSum - leftSum));
            }
        }
        
        return result;
    }
}