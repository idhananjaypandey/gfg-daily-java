class Solution {
    public int firstElementKTime(int[] arr, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int num : arr) {
            int count = countMap.getOrDefault(num, 0) + 1;
            if (count == k) {
                return num;
            }
            countMap.put(num, count);
        }

        return -1;
    }
}