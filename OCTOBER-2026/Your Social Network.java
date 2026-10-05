// Your Social Network

class Solution {
    public ArrayList<ArrayList<Integer>> socialNetwork(int[] arr) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int n = arr.length + 1;
        
        for (int i = 2; i <= n; i++) {
            int parent = arr[i - 2];
            int dist = 1;
            
            int tempI = i;
            int tempParent = parent;
            
            boolean[] isReachable = new boolean[i];
            int[] distTo = new int[i];
            
            while (true) {
                isReachable[tempParent] = true;
                distTo[tempParent] = dist;
                
                if (tempParent == 1) {
                    break;
                }
                
                tempParent = arr[tempParent - 2];
                dist++;
            }
            
            for (int j = 1; j < i; j++) {
                if (isReachable[j]) {
                    result.add(new ArrayList<>(Arrays.asList(i, j, distTo[j])));
                }
            }
        }
        
        return result;
    }
}