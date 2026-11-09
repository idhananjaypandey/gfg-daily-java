class Solution {
    int getCount(String s, int k) {
        java.util.Map<Character, Integer> groupCount = new java.util.HashMap<>();
        int n = s.length();
        int i = 0;
        while (i < n) {
            char c = s.charAt(i);
            int j = i;
            while (j < n && s.charAt(j) == c) {
                j++;
            }
            groupCount.put(c, groupCount.getOrDefault(c, 0) + 1);
            i = j;
        }
        int ans = 0;
        for (int count : groupCount.values()) {
            if (count == k) {
                ans++;
            }
        }
        return ans;
    }
}