// Transform to Sum Tree

/* Structure for Tree Node
class Node {
    int data;
    Node left, right;

    // Constructor
    Node(int val) {
        data = val;
        left = null;
        right = null;
    }
};
*/
class Solution {

    // Function to convert tree into Sum Tree
    public void toSumTree(Node root) {
        solve(root);
    }

    // Returns sum of original subtree values
    private int solve(Node node) {

        // Base case
        if (node == null) {
            return 0;
        }

        // Store old value
        int oldValue = node.data;

        // Recursively get left and right subtree sums
        int leftSum = solve(node.left);
        int rightSum = solve(node.right);

        // Update current node value
        node.data = leftSum + rightSum;

        // Return total sum including original node value
        return node.data + oldValue;
    }
}