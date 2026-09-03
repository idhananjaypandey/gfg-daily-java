// Max Adjacent Diffs Sum with 1 Replacements

class Solution {
    public int maxDiffSum(int[] arr) {
        int n = arr.length;
        if (n <= 1) return 0;

        int dpOriginal = 0;
        int dpOne = 0;

        for (int i = 1; i < n; i++) {
            int newOriginal = Math.max(
                dpOriginal + Math.abs(arr[i] - arr[i - 1]),
                dpOne + Math.abs(arr[i] - 1)
            );
            int newOne = Math.max(
                dpOriginal + Math.abs(1 - arr[i - 1]),
                dpOne + Math.abs(1 - 1)
            );

            dpOriginal = newOriginal;
            dpOne = newOne;
        }

        return Math.max(dpOriginal, dpOne);
    }
}