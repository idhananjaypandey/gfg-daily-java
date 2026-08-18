// Secret Cipher

class Solution {
    public String compress(String s) {
        int n = s.length();
        int[] lps = new int[n];
        for (int i = 1; i < n; i++) {
            int j = lps[i - 1];
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = lps[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            lps[i] = j;
        }

        StringBuilder sb = new StringBuilder();
        int i = n - 1;

        while (i >= 0) {
            if (i % 2 == 1) {
                int halfLen = (i + 1) / 2;
                int k = lps[i];

                while (k > halfLen) {
                    k = lps[k - 1];
                }

                if (k == halfLen) {
                    sb.append('*');
                    i = halfLen - 1;
                    continue;
                }
            }
            sb.append(s.charAt(i));
            i--;
        }

        return sb.reverse().toString();
    }
}