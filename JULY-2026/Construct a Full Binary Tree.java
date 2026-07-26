// Construct a Full Binary Tree

/* Structure of Binary Tree Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
} */

class Solution {
    private int preIndex = 0;

    public Node constructBinaryTree(int[] pre, int[] preMirror) {
        preIndex = 0;
        return constructHelper(pre, preMirror, 0, preMirror.length - 1, pre.length);
    }

    private Node constructHelper(int[] pre, int[] preMirror, int l, int h, int size) {
        if (preIndex >= size || l > h) {
            return null;
        }

        Node root = new Node(pre[preIndex++]);

        if (l == h || preIndex >= size) {
            return root;
        }

        int i;
        for (i = l; i <= h; i++) {
            if (preMirror[i] == pre[preIndex]) {
                break;
            }
        }

        if (i <= h) {
            root.left = constructHelper(pre, preMirror, i, h, size);
            root.right = constructHelper(pre, preMirror, l + 1, i - 1, size);
        }

        return root;
    }
}