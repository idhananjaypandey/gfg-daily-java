class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int maxTime = 0;
      
        // For ants moving left, the time to fall off equals their position
        for (int position : left) {
            maxTime = Math.max(maxTime, position);
        }
      
        // For ants moving right, the time to fall off equals (plank length - position)
        for (int position : right) {
            maxTime = Math.max(maxTime, n - position);
        }
      
        return maxTime;
    }
}