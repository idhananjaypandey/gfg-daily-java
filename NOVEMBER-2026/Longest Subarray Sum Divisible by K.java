class Solution {
    public int longestSubarrayDivK(int[] arr, int k) {
        HashMap<Integer, Integer> remIndex = new HashMap<>();
        remIndex.put(0, -1);

        long prefixSum = 0;
        int maxLen = 0;

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            int rem = (int) (prefixSum % k);
            if (rem < 0) {
                rem += k;
            }

            if (remIndex.containsKey(rem)) {
                maxLen = Math.max(maxLen, i - remIndex.get(rem));
            } else {
                remIndex.put(rem, i);
            }
        }

        return maxLen;
    }
}