// Construct List using XOR Queries

class Solution {
    public ArrayList<Integer> constructList(int[][] queries) {
        ArrayList<Integer> result = new ArrayList<>();
        int cumulativeXor = 0;
        int q = queries.length;

        // Traverse the queries in reverse order
        for (int i = q - 1; i >= 0; i--) {
            int type = queries[i][0];
            int x = queries[i][1];

            if (type == 1) {
                // Accumulate the XOR value for elements inserted before this query
                cumulativeXor ^= x;
            } else {
                // Element x is only affected by XOR queries that came AFTER it
                result.add(x ^ cumulativeXor);
            }
        }

        // The initial element 0 is affected by ALL type 1 queries
        result.add(0 ^ cumulativeXor);

        // The problem requires the final array to be in sorted order
        Collections.sort(result);

        return result;
    }
}