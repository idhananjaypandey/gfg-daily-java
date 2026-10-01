// Minimum Time to Finish Project

class Solution {
    public int minTime(int[] duration, int[][] dependencies) {
        int n = duration.length;
        List<List<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[n];
        
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] dep : dependencies) {
            int u = dep[0];
            int v = dep[1];
            adj.get(u).add(v);
            inDegree[v]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        int[] completionTime = new int[n];
        
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
                completionTime[i] = duration[i];
            }
        }
        
        int processedCount = 0;
        int maxTime = 0;
        
        while (!queue.isEmpty()) {
            int u = queue.poll();
            processedCount++;
            maxTime = Math.max(maxTime, completionTime[u]);
            
            for (int v : adj.get(u)) {
                completionTime[v] = Math.max(completionTime[v], completionTime[u] + duration[v]);
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        
        return processedCount == n ? maxTime : -1;
    }
}