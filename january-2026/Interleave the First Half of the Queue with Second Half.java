import java.util.*;

class Solution {
    public static void rearrangeQueue(Queue<Integer> q) {
        // Base case: check if empty or odd length 
        if (q == null || q.isEmpty() || q.size() % 2 != 0) {
            return;
        }

        int n = q.size();
        int k = n / 2;
        Stack<Integer> s = new Stack<>();

        // Step 1: Move first half to stack
        for (int i = 0; i < k; i++) {
            s.push(q.poll());
        }

        // Step 2: Move stack back to queue 
        while (!s.isEmpty()) {
            q.add(s.pop());
        }

        // Step 3: Move front half (originally 2nd half) to the rear
        for (int i = 0; i < k; i++) {
            q.add(q.poll());
        }

        // Step 4: Move first half back to stack
        for (int i = 0; i < k; i++) {
            s.push(q.poll());
        }

        // Step 5: Interleave stack and queue
        while (!s.isEmpty()) {
            q.add(s.pop());
            q.add(q.poll());
        }
    }
}