// Check Subset sum divisible by k

class Solution {
    public boolean divisibleByK(int[] arr, int k) {
        int n = arr.length;
        if (k == 1) return true;

        boolean[] dp = new boolean[k];

        for (int num : arr) {
            int currentRem = num % k;
            if (currentRem == 0) return true;

            boolean[] nextDp = dp.clone();
            nextDp[currentRem] = true;

            for (int i = 0; i < k; i++) {
                if (dp[i]) {
                    int nextRem = (i + currentRem) % k;
                    if (nextRem == 0) return true;
                    nextDp[nextRem] = true;
                }
            }
            dp = nextDp;
        }

        return dp[0];
    }
}