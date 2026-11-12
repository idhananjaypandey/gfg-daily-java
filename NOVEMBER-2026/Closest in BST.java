class Solution {
    public int minDiff(Node root, int k) {
        int minDiff = Integer.MAX_VALUE;
        Node curr = root;
        while (curr != null) {
            minDiff = Math.min(minDiff, Math.abs(curr.data - k));
            if (curr.data == k) {
                return 0;
            } else if (curr.data > k) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        return minDiff;
    }
}