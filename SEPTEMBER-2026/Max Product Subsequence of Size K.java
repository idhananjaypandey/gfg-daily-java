// Max Product Subsequence of Size K

class Solution {
    public int maxProduct(int[] arr, int k) {
        int n = arr.length;
        Arrays.sort(arr);
        
        int prod = 1;
        
        if (arr[n - 1] == 0 && k % 2 != 0) {
            return 0;
        }
        
        if (arr[n - 1] < 0) {
            if (k % 2 != 0) {
                for (int i = n - 1; i >= n - k; i--) {
                    prod *= arr[i];
                }
                return prod;
            }
        }
        
        int i = 0;
        int j = n - 1;
        
        if (k % 2 != 0) {
            prod *= arr[j];
            j--;
            k--;
        }
        
        while (k > 0) {
            int leftProduct = arr[i] * arr[i + 1];
            int rightProduct = arr[j] * arr[j - 1];
            
            if (leftProduct > rightProduct) {
                prod *= leftProduct;
                i += 2;
            } else {
                prod *= rightProduct;
                j -= 2;
            }
            k -= 2;
        }
        
        return prod;
    }
}