// Subset Sum on Generated Sequence

class Solution {
    public boolean isPossible(int[] arr, int s, int x) {
        List<Long> seq = new ArrayList<>();
        long currentVal = s;
        seq.add(currentVal);
        long runningSum = currentVal;

        for (int num : arr) {
            long nextVal = runningSum + num;
            if (nextVal > x) {
                break;
            }
            seq.add(nextVal);
            runningSum += nextVal;
        }

        long target = x;
        for (int i = seq.size() - 1; i >= 0; i--) {
            if (seq.get(i) <= target) {
                target -= seq.get(i);
            }
        }

        return target == 0;
    }
}