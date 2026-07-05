// Max Gap Between Two Same

class Solution {
    public int maxCharGap(String s) {
        HashMap<Character, Integer> firstOccurrence = new HashMap<>();
        int maxGap = -1;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (firstOccurrence.containsKey(ch)) {
                int gap = i - firstOccurrence.get(ch) - 1;
                if (gap > maxGap) {
                    maxGap = gap;
                }
            } else {
                firstOccurrence.put(ch, i);
            }
        }

        return maxGap;
    }
}