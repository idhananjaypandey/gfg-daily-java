// Longest Subsequence with Adjacent Diff as 1

class Solution {
    public int longestSubseq(int[] arr) {
        HashMap<Integer, Integer> dp = new HashMap<>();
        int maxLength = 0;

        for (int num : arr) {
            int len1 = dp.getOrDefault(num - 1, 0);
            int len2 = dp.getOrDefault(num + 1, 0);
            
            int currentLength = Math.max(len1, len2) + 1;
            dp.put(num, currentLength);
            
            maxLength = Math.max(maxLength, currentLength);
        }

        return maxLength;
    }
}