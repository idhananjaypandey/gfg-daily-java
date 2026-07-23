// Check Preorder of BST

class Solution {
    public boolean canRepresentBST(List<Integer> arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        int root = Integer.MIN_VALUE;

        for (int val : arr) {
            if (val < root) {
                return false;
            }
            while (!stack.isEmpty() && stack.peek() < val) {
                root = stack.pop();
            }
            stack.push(val);
        }
        return true;
    }
}