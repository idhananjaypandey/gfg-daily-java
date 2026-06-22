// Maximum Area Between Bars

class Solution {
    public int maxArea(List<Integer> height) {
        int left = 0;
        int right = height.size() - 1;
        int maxArea = 0;
        
        while (left < right - 1) {
            int width = right - left - 1; 
            int currentHeight = Math.min(height.get(left), height.get(right));
            int currentArea = currentHeight * width;
            maxArea = Math.max(maxArea, currentArea);
            
            if (height.get(left) < height.get(right)) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxArea;
    }
}