import java.util.ArrayList;

class Solution {

    public ArrayList<ArrayList<Integer>> permuteDist(int[] arr) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[arr.length];
        ArrayList<Integer> currentPermutation = new ArrayList<>();

        backtrack(arr, used, currentPermutation, result);
        return result;
    }

    private void backtrack(int[] arr, boolean[] used, ArrayList<Integer> currentPermutation, ArrayList<ArrayList<Integer>> result) {
        // Base case: current permutation is complete
        if (currentPermutation.size() == arr.length) {
            result.add(new ArrayList<>(currentPermutation));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!used[i]) {
                // Explore this path
                currentPermutation.add(arr[i]);
                used[i] = true;

                backtrack(arr, used, currentPermutation, result);

                // Backtrack: Undo the choice
                used[i] = false;
                currentPermutation.remove(currentPermutation.size() - 1);
            }
        }
    }
}