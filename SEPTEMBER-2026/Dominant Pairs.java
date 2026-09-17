// Dominant Pairs

class Solution {
    public int dominantPairs(int[] arr) {
        int n = arr.length;
        int mid = n / 2;

        Arrays.sort(arr, 0, mid);
        Arrays.sort(arr, mid, n);

        int count = 0;
        int i = 0;
        int j = mid;

        while (i < mid && j < n) {
            if (arr[i] >= 5 * arr[j]) {
                count += (mid - i);
                j++;
            } else {
                i++;
            }
        }

        return count;
    }
}