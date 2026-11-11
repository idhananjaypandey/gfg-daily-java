class Solution {
    public boolean checkWithinK(int[] arr, int k) {
        java.util.HashSet<Integer> window = new java.util.HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (window.contains(arr[i])) {
                return true;
            }
            window.add(arr[i]);
            if (i >= k) {
                window.remove(arr[i - k]);
            }
        }
        return false;
    }
}