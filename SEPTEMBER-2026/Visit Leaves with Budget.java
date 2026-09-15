// Visit Leaves with Budget

/* Binary Tree Node Structure
class Node {
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
    }
}
*/
class Solution {
    public int getCount(Node root, int k) {
        if (root == null) return 0;

                Queue<Node> queue = new LinkedList<>();
                Queue<Integer> levelQueue = new LinkedList<>();

                queue.add(root);
                levelQueue.add(1); // Root is at level 1

                int count = 0;

                while (!queue.isEmpty()) {
                    Node curr = queue.poll();
                    int level = levelQueue.poll();

                    // Check if current node is a leaf node
                    if (curr.left == null && curr.right == null) {
                        if (k >= level) {
                            k -= level; // Deduct cost from budget
                            count++;    // Increment visited leaf count
                        } else {
                            break;      // Cannot afford any more leaves
                        }
                    }

                    // Push left and right children to the queue
                    if (curr.left != null) {
                        queue.add(curr.left);
                        levelQueue.add(level + 1);
                    }
                    if (curr.right != null) {
                        queue.add(curr.right);
                        levelQueue.add(level + 1);
                    }
                }

                return count;
        
    }
}