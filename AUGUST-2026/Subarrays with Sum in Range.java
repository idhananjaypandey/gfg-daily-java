// Subarrays with Sum in Range

class Solution {
    public int countSubarray(int[] arr, int l, int r) {
        return (int) (countLessEqual(arr, r) - countLessEqual(arr, l - 1));
    }

    private long countLessEqual(int[] arr, long target) {
        long count = 0;
        long sum = 0;
        int left = 0;
        for (int right = 0; right < arr.length; right++) {
            sum += arr[right];
            while (sum > target && left <= right) {
                sum -= arr[left];
                left++;
            }
            count += (right - left + 1);
        }
        return count;
    }
}