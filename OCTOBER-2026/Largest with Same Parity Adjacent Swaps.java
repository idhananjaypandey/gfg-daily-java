// Largest with Same Parity Adjacent Swaps

class Solution {
    public ArrayList<Integer> lexicographicallyLargest(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();
        int n = arr.length;
        int i = 0;
        
        while (i < n) {
            int j = i;
            while (j < n && (arr[j] % 2) == (arr[i] % 2)) {
                j++;
            }
            
            ArrayList<Integer> sub = new ArrayList<>();
            for (int k = i; k < j; k++) {
                sub.add(arr[k]);
            }
            
            Collections.sort(sub, Collections.reverseOrder());
            result.addAll(sub);
            
            i = j;
        }
        
        return result;
    }
}