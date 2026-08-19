// Node and Ancestor Max Diff

/* Structure of binary tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/

class Solution {
    int maxDiff = Integer.MIN_VALUE;

    int maxDiff(Node root) {
        maxDiff = Integer.MIN_VALUE;
        solve(root);
        return maxDiff;
    }

    private int solve(Node node) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }

        // Base case: Leaf node has no descendants, return its value
        if (node.left == null && node.right == null) {
            return node.data;
        }

        // Recursively find the minimum value in left and right subtrees
        int leftMin = solve(node.left);
        int rightMin = solve(node.right);

        // Minimum descendant value for the current node
        int minDescendant = Math.min(leftMin, rightMin);

        // Update maximum difference (Ancestor - Descendant)
        maxDiff = Math.max(maxDiff, node.data - minDescendant);

        // Return the minimum value in the subtree rooted at current node
        return Math.min(node.data, minDescendant);
    }
}