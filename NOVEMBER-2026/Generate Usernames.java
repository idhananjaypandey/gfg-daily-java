import java.util.*;

class Solution {
    public ArrayList<String> generateUsernames(String[] arr) {
        ArrayList<String> result = new ArrayList<>();
        Set<String> reserved = new HashSet<>();
        Set<String> assigned = new HashSet<>();
        Map<String, Integer> nextSuffix = new HashMap<>();

        for (String s : arr) {
            reserved.add(s);
        }

        for (String s : arr) {
            if (!assigned.contains(s)) {
                result.add(s);
                assigned.add(s);
            } else {
                int k = nextSuffix.getOrDefault(s, 1);
                String candidate = s + k;
                while (reserved.contains(candidate) || assigned.contains(candidate)) {
                    k++;
                    candidate = s + k;
                }
                result.add(candidate);
                assigned.add(candidate);
                nextSuffix.put(s, k + 1);
            }
        }

        return result;
    }
}