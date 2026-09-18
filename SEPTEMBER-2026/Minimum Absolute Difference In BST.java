// Minimum Absolute Difference In BST

/* The Node structure is defined as
 class Node {
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    private int minDiff = Integer.MAX_VALUE;
    private Node prev = null;

    public int absDiff(Node root) {
        inorder(root);
        return minDiff;
    }

    private void inorder(Node node) {
        if (node == null) {
            return;
        }

        inorder(node.left);

        if (prev != null) {
            minDiff = Math.min(minDiff, node.data - prev.data);
        }
        prev = node;

        inorder(node.right);
    }
}