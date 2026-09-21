// Check Level Anagrams in Binary Trees

/* Structure of binary tree Node
class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/

class Solution {
    public boolean areAnagrams(Node root1, Node root2) {
        if (root1 == null && root2 == null) return true;
                if (root1 == null || root2 == null) return false;

                Queue<Node> q1 = new LinkedList<>();
                Queue<Node> q2 = new LinkedList<>();

                q1.add(root1);
                q2.add(root2);

                while (!q1.isEmpty() && !q2.isEmpty()) {
                    int n1 = q1.size();
                    int n2 = q2.size();

                    // If the number of nodes at the current level differs
                    if (n1 != n2) return false;

                    Map<Integer, Integer> map = new HashMap<>();

                    // Process current level of root1
                    for (int i = 0; i < n1; i++) {
                        Node node1 = q1.poll();
                        map.put(node1.data, map.getOrDefault(node1.data, 0) + 1);

                        if (node1.left != null) q1.add(node1.left);
                        if (node1.right != null) q1.add(node1.right);
                    }

                    // Process current level of root2 and compare frequency
                    for (int i = 0; i < n2; i++) {
                        Node node2 = q2.poll();

                        // If value not present or frequency count exceeded
                        if (!map.containsKey(node2.data) || map.get(node2.data) == 0) {
                            return false;
                        }

                        map.put(node2.data, map.get(node2.data) - 1);

                        if (node2.left != null) q2.add(node2.left);
                        if (node2.right != null) q2.add(node2.right);
                    }
                }

                // Both queues should be empty if both trees have the same height
                return q1.isEmpty() && q2.isEmpty();
            
    }
}
