class Solution {
    public int countEdges(ArrayList<ArrayList<Integer>> adj) {
        int totalDegree = 0;
        for (int i = 0; i < adj.size(); i++) {
            totalDegree += adj.get(i).size();
        }
        return totalDegree / 2;
    }
}