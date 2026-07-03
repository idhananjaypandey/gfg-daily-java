// Substrings with more 1's than 0's

class Solution {

    class Fenwick {
        int[] bit;
        int n;

        Fenwick(int n) {
            this.n = n;
            bit = new int[n + 2];
        }

        void update(int index, int val) {
            while (index <= n) {
                bit[index] += val;
                index += index & (-index);
            }
        }

        int query(int index) {
            int sum = 0;
            while (index > 0) {
                sum += bit[index];
                index -= index & (-index);
            }
            return sum;
        }
    }

    public int countSubstring(String s) {

        int n = s.length();

        int offset = n + 2;

        Fenwick ft = new Fenwick(2 * n + 5);

        int prefix = 0;
        int ans = 0;

        // Insert empty prefix sum (0)
        ft.update(offset, 1);

        for (int i = 0; i < n; i++) {

            if (s.charAt(i) == '1')
                prefix++;
            else
                prefix--;

            int index = prefix + offset;

            // Count previous prefix sums smaller than current
            ans += ft.query(index - 1);

            // Insert current prefix sum
            ft.update(index, 1);
        }

        return ans;
    }
}