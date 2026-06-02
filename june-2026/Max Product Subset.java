// Max Product Subset

import java.util.List;

class Solution {
    public int findMaxProduct(int[] arr) {
        int n = arr.length;
        
        // Edge case: If there is only one element, return it.
        if (n == 1) {
            return arr[0];
        }

        long MOD = 1000000007;
        int maxNegative = Integer.MIN_VALUE;
        int countNegative = 0;
        int countZero = 0;
        long product = 1;
        boolean hasProductComponents = false;

        for (int i = 0; i < n; i++) {
            int val = arr[i];

            if (val == 0) {
                countZero++;
                continue;
            }

            if (val < 0) {
                countNegative++;
                maxNegative = Math.max(maxNegative, val);
            }

            // Keep track of the product of all non-zero numbers
            product = (product * val);
            
            // Handle intermediate negative results safely with modulo 
            // by keeping it positive during calculation steps
            if (product < 0) {
                product = (product % MOD + MOD) % MOD;
            } else {
                product = product % MOD;
            }
            
            hasProductComponents = true;
        }

        // Edge Case 1: If all elements are zeros
        if (countZero == n) {
            return 0;
        }

        // Edge Case 2: If there's exactly one negative number and everything else is zero
        if (countNegative == 1 && countZero + countNegative == n) {
            return 0;
        }

        // If there is an odd number of negative numbers, 
        // we must divide out the largest negative number (closest to 0) from the product.
        if (countNegative % 2 != 0) {
            // Since we need to divide in modular arithmetic, we compute the modular inverse.
            // Alternatively, doing a clean recalculation loop is safer against 0/inverse edge cases.
            long finalProduct = 1;
            boolean skipped = false;
            
            for (int i = 0; i < n; i++) {
                int val = arr[i];
                if (val == 0) continue;
                
                if (val == maxNegative && !skipped) {
                    skipped = true;
                    continue;
                }
                
                finalProduct = (finalProduct * val);
                if (finalProduct < 0) {
                    finalProduct = (finalProduct % MOD + MOD) % MOD;
                } else {
                    finalProduct = finalProduct % MOD;
                }
            }
            return (int) finalProduct;
        }

        return (int) product;
    }
}