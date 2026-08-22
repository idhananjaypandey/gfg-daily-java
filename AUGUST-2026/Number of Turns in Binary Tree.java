// Number of Turns in Binary Tree

class Solution {
    static int turns = 0;

    // Find Lowest Common Ancestor (LCA)
    private static Node findLCA(Node root, int p, int q) {
        if (root == null) return null;
        if (root.data == p || root.data == q) return root;

        Node left = findLCA(root.left, p, q);
        Node right = findLCA(root.right, p, q);

        if (left != null && right != null) return root;
        return (left != null) ? left : right;
    }

    // Count turns going downwards from root to target
    private static boolean countTurns(Node root, int target, boolean turn) {
        if (root == null) return false;
        if (root.data == target) return true;

        // Moving left (true = left, false = right)
        if (countTurns(root.left, target, true)) {
            if (!turn) turns++; // Direction changed from right to left
            return true;
        }

        // Moving right
        if (countTurns(root.right, target, false)) {
            if (turn) turns++; // Direction changed from left to right
            return true;
        }

        return false;
    }

    public int numberOfTurns(Node root, int p, int q) {
        turns = 0;
        Node lca = findLCA(root, p, q);

        if (lca == null) return -1;

        // If LCA is p or q, count turns along a single path
        if (lca.data == p) {
            countTurns(lca.left, q, true);
            countTurns(lca.right, q, false);
        } else if (lca.data == q) {
            countTurns(lca.left, p, true);
            countTurns(lca.right, p, false);
        } else {
            // Path goes through LCA, adding 1 turn at LCA itself
            countTurns(lca.left, p, true);
            countTurns(lca.right, p, false);
            countTurns(lca.left, q, true);
            countTurns(lca.right, q, false);
            turns++; // Transition at LCA
        }

        return (turns == 0) ? -1 : turns;
    }
}