// Last Coin in a Game of Alternates

class Solution {
    
    public int coin(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        // Continue until one coin remains
        while (left < right) {

            // Remove the larger coin
            if (arr[left] >= arr[right]) {
                left++;
            } else {
                right--;
            }
        }

        // Last remaining coin
        return arr[left];
    }
}