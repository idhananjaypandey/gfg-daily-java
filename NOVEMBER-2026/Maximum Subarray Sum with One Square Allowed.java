class Solution {
    public int maximumSubarray(int[] arr) {
        int n = arr.length;
        long[] maxEndingHere = new long[n];
        long[] maxEndingHereSquared = new long[n];
        
        maxEndingHere[0] = arr[0];
        maxEndingHereSquared[0] = (long) arr[0] * arr[0];
        
        long maxSum = Math.max(maxEndingHere[0], maxEndingHereSquared[0]);
        
        for (int i = 1; i < n; i++) {
            long val = arr[i];
            long valSq = val * val;
            
            maxEndingHere[i] = Math.max(val, maxEndingHere[i - 1] + val);
            
            long opt1 = valSq;
            long opt2 = maxEndingHere[i - 1] + valSq;
            long opt3 = maxEndingHereSquared[i - 1] + val;
            
            maxEndingHereSquared[i] = Math.max(opt1, Math.max(opt2, opt3));
            
            maxSum = Math.max(maxSum, Math.max(maxEndingHere[i], maxEndingHereSquared[i]));
        }
        
        return (int) maxSum;
    }
}