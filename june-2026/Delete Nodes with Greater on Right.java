// Delete Nodes with Greater on Right

class Solution {
    public Node compute(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Step 1: Reverse the linked list
        head = reverse(head);

        // Step 2: Traverse and delete nodes smaller than the max seen so far
        Node current = head;
        Node maxNode = head;
        
        while (current != null && current.next != null) {
            if (current.next.data < maxNode.data) {
                // Skip the next node
                current.next = current.next.next;
            } else {
                // Update current and move the maxNode pointer
                current = current.next;
                maxNode = current;
            }
        }

        // Step 3: Reverse the list back to its original order
        return reverse(head);
    }

    // Helper method to reverse a linked list
    private Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;
        
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}