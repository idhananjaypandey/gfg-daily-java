class Solution {
    public int maxEqualSum(ArrayList<Integer> s1, ArrayList<Integer> s2, ArrayList<Integer> s3) {
        int sum1 = 0, sum2 = 0, sum3 = 0;
        
        for (int num : s1) sum1 += num;
        for (int num : s2) sum2 += num;
        for (int num : s3) sum3 += num;
        
        int top1 = 0, top2 = 0, top3 = 0;
        
        while (top1 < s1.size() && top2 < s2.size() && top3 < s3.size()) {
            if (sum1 == sum2 && sum2 == sum3) {
                return sum1;
            }
            
            if (sum1 >= sum2 && sum1 >= sum3) {
                sum1 -= s1.get(top1++);
            } else if (sum2 >= sum1 && sum2 >= sum3) {
                sum2 -= s2.get(top2++);
            } else {
                sum3 -= s3.get(top3++);
            }
        }
        
        return 0;
    }
}