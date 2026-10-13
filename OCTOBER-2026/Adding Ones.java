// Adding Ones

class Solution {
    public ArrayList<Integer> update(int n, int[] updates) {
        int[] arr = new int[n];
        for (int x : updates) {
            arr[x - 1]++;
        }
        for (int i = 1; i < n; i++) {
            arr[i] += arr[i - 1];
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int val : arr) {
            result.add(val);
        }
        return result;
    }
}