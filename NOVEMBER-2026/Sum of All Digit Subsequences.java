class Solution {
    public int subsequenceSum(String s) {
        long mod = 1000000007L;
        long digitSum = 0;
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            digitSum = (digitSum + (s.charAt(i) - '0')) % mod;
        }
        
        long powerOfTwo = 1;
        for (int i = 0; i < n - 1; i++) {
            powerOfTwo = (powerOfTwo * 2) % mod;
        }
        
        return (int) ((digitSum * powerOfTwo) % mod);
    }
}