import java.util.*;

class Solution {
    /**
     * The driver code in GfG.java expects this exact method name.
     */
    public int countSubset(int[] arr, int sum) {
        int n = arr.length;
        if (n == 0) return 0;

        // Split the array into two halves (Meet-in-the-middle)
        int mid = n / 2;

        // Generate frequency maps for subset sums of both halves
        Map<Long, Long> leftSums = generateSumMap(arr, 0, mid);
        Map<Long, Long> rightSums = generateSumMap(arr, mid, n);

        long totalCount = 0;

        // Iterate through left side sums and find the required complement in the right side
        for (Map.Entry<Long, Long> entry : leftSums.entrySet()) {
            long s1 = entry.getKey();
            long count1 = entry.getValue();
            long s2Needed = (long) sum - s1;

            if (rightSums.containsKey(s2Needed)) {
                totalCount += count1 * rightSums.get(s2Needed);
            }
        }

        // The driver code expects an 'int' return type based on your error message
        return (int) totalCount;
    }

    private Map<Long, Long> generateSumMap(int[] arr, int start, int end) {
        Map<Long, Long> sumMap = new HashMap<>();
        int n = end - start;
        int totalSubsets = 1 << n;

        for (int i = 0; i < totalSubsets; i++) {
            long currentSum = 0;
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 1) {
                    currentSum += arr[start + j];
                }
            }
            sumMap.put(currentSum, sumMap.getOrDefault(currentSum, 0L) + 1);
        }
        return sumMap;
    }
}