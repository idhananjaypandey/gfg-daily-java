// Marks from Ranks

class Solution {
    public ArrayList<Integer> getMarks(int[] l, int[] r, int[] rank) {
        int n = l.length;
        long[] pref = new long[n];

        // Step 1: Compute prefix sums of total elements covered by intervals
        long totalCount = 0;
        for (int i = 0; i < n; i++) {
            totalCount += (r[i] - l[i] + 1);
            pref[i] = totalCount;
        }

        ArrayList<Integer> result = new ArrayList<>();

        // Step 2: Process each rank query using binary search
        for (int targetRank : rank) {
            int low = 0, high = n - 1;
            int intervalIdx = n - 1;

            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (pref[mid] >= targetRank) {
                    intervalIdx = mid;
                    high = mid - 1; // Try to find a smaller valid interval index
                } else {
                    low = mid + 1;
                }
            }

            // Step 3: Calculate the offset within the matched interval
            long prevCount = (intervalIdx > 0) ? pref[intervalIdx - 1] : 0;
            long offset = targetRank - prevCount;
            long mark = l[intervalIdx] + offset - 1;

            result.add((int) mark);
        }

        return result;
    }
}