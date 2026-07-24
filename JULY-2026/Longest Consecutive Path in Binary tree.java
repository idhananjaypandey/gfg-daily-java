// Longest Consecutive Path in Binary tree

/* Structure of Binary Tree Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
}*/
class Solution {
    private int maxLen = 0;

    public int longestConsecutive(Node root) {
        if (root == null) return -1;

        maxLen = 0;
        dfs(root, 1);

        // If no consecutive sequence of length >= 2 exists, return -1
        return maxLen > 1 ? maxLen : -1;
    }

    private void dfs(Node node, int currentLen) {
        if (node == null) return;

        maxLen = Math.max(maxLen, currentLen);

        // Traverse left child
        if (node.left != null) {
            if (node.left.data == node.data + 1) {
                dfs(node.left, currentLen + 1);
            } else {
                dfs(node.left, 1);
            }
        }

        // Traverse right child
        if (node.right != null) {
            if (node.right.data == node.data + 1) {
                dfs(node.right, currentLen + 1);
            } else {
                dfs(node.right, 1);
            }
        }
    }
}