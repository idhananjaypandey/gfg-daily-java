// Maximum Subset XOR

class Solution {
    public static int maxSubsetXOR(int[] arr) {
        int index = 0;
        int n = arr.length;
        
        for (int i = 31; i >= 0; i--) {
            int maxInd = index;
            int maxVal = Integer.MIN_VALUE;
            
            for (int j = index; j < n; j++) {
                if ((arr[j] & (1 << i)) != 0 && arr[j] > maxVal) {
                    maxVal = arr[j];
                    maxInd = j;
                }
            }
            
            if (maxVal == Integer.MIN_VALUE) {
                continue;
            }
            
            int temp = arr[index];
            arr[index] = arr[maxInd];
            arr[maxInd] = temp;
            
            maxInd = index;
            
            for (int j = 0; j < n; j++) {
                if (j != maxInd && (arr[j] & (1 << i)) != 0) {
                    arr[j] ^= arr[maxInd];
                }
            }
            
            index++;
        }
        
        int maxXor = 0;
        for (int i = 0; i < n; i++) {
            maxXor ^= arr[i];
        }
        
        return maxXor;
    }
}
