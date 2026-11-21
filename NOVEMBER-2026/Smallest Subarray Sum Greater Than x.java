class Solution {
    public int smallestSubWithSum(int[] arr, int x) {
        int n = arr.length;
        int minLen = n + 1;
        int currentSum = 0;
        int start = 0;

        for (int end = 0; end < n; end++) {
            currentSum += arr[end];

            while (currentSum > x) {
                minLen = Math.min(minLen, end - start + 1);
                currentSum -= arr[start];
                start++;
            }
        }

        return (minLen == n + 1) ? 0 : minLen;
    }
}