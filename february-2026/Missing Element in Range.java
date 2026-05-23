import java.util.*;

class Solution {
    // Change the return type from List<Integer> to ArrayList<Integer>
    public ArrayList<Integer> missingRange(int[] arr, int low, int high) {
        ArrayList<Integer> result = new ArrayList<>();
        
        Set<Integer> presenceSet = new HashSet<>();
        for (int num : arr) {
            presenceSet.add(num);
        }

        for (int i = low; i <= high; i++) {
            if (!presenceSet.contains(i)) {
                result.add(i);
            }
        }
        
        return result;
    }
}