class Solution {
    public void sortIt(int[] arr) {
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();

        for (int num : arr) {
            if ((num & 1) == 1) {
                odd.add(num);
            } else {
                even.add(num);
            }
        }

        odd.sort(Collections.reverseOrder());
        Collections.sort(even);

        int idx = 0;
        for (int num : odd) {
            arr[idx++] = num;
        }
        for (int num : even) {
            arr[idx++] = num;
        }
    }
}