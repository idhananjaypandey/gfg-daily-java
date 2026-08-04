// Pairs with Less Than K Diff

class Solution {
    public int countPairs(int[] arr, int k) {
        int n = arr.length;
        Arrays.sort(arr);
        int count = 0;
        int j = 0;

        for (int i = 0; i < n; i++) {
            while (j < n && arr[j] - arr[i] < k) {
                j++;
            }
            count += (j - i - 1);
        }

        return count;
    }
}