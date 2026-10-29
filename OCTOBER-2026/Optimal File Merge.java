class Solution {
    public int minComputation(int[] files) {
        java.util.PriorityQueue<Integer> minHeap = new java.util.PriorityQueue<>();
        for (int file : files) {
            minHeap.add(file);
        }
        
        int totalCost = 0;
        while (minHeap.size() > 1) {
            int first = minHeap.poll();
            int second = minHeap.poll();
            int cost = first + second;
            totalCost += cost;
            minHeap.add(cost);
        }
        
        return totalCost;
    }
}