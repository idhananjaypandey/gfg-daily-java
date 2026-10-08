// Maximum Frequency with K Increments

class Solution {
    public int maxFrequency(int[] arr, int k) {
        Arrays.sort(arr);
        
        int maxFreq = 1;
        int left = 0;
        long totalCost = 0;

        for (int right = 1; right < arr.length; right++) {
            totalCost += (long) (arr[right] - arr[right - 1]) * (right - left);

            while (totalCost > k) {
                totalCost -= (arr[right] - arr[left]);
                left++;
            }

            maxFreq = Math.max(maxFreq, right - left + 1);
        }

        return maxFreq;
    }
}