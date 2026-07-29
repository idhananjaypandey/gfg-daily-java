// Split Array into Minimum Subsets

class Solution {
    public int minSubsets(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        
        Arrays.sort(arr);
        int count = 1;
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1] + 1) {
                count++;
            }
        }
        
        return count;
    }
}