// Max Path Sum Between Two Leaves

/* Node Structure
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
} */
class Solution {
    int maxSoFar = Integer.MIN_VALUE;

    public int maxPathSum(Node root) {
        int res = solve(root);
        if (root == null) return -1;
        if (root.left == null || root.right == null) {
            if (maxSoFar == Integer.MIN_VALUE) {
                return -1;
            }
            return maxSoFar;
        }
        return maxSoFar;
    }

    private int solve(Node node) {
        if (node == null) return 0;

        if (node.left == null && node.right == null) {
            return node.data;
        }

        if (node.left == null) {
            return node.data + solve(node.right);
        }

        if (node.right == null) {
            return node.data + solve(node.left);
        }

        int leftSum = solve(node.left);
        int rightSum = solve(node.right);

        maxSoFar = Math.max(maxSoFar, leftSum + rightSum + node.data);

        return node.data + Math.max(leftSum, rightSum);
    }
}