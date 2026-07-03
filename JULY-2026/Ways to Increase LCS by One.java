// Ways to Increase LCS by One

class Solution {
    public int waysToIncreaseLCSBy1(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();

        int[][] dpL = new int[n1 + 2][n2 + 2];
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dpL[i][j] = dpL[i - 1][j - 1] + 1;
                } else {
                    dpL[i][j] = Math.max(dpL[i - 1][j], dpL[i][j - 1]);
                }
            }
        }

        int origLCS = dpL[n1][n2];

        int[][] dpR = new int[n1 + 2][n2 + 2];
        for (int i = n1; i >= 1; i--) {
            for (int j = n2; j >= 1; j--) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dpR[i][j] = dpR[i + 1][j + 1] + 1;
                } else {
                    dpR[i][j] = Math.max(dpR[i + 1][j], dpR[i][j + 1]);
                }
            }
        }

        int totalWays = 0;

        for (int i = 0; i <= n1; i++) {
            boolean[] validChar = new boolean[26];
            for (int j = 1; j <= n2; j++) {
                char ch = s2.charAt(j - 1);
                if (!validChar[ch - 'a']) {
                    if (dpL[i][j - 1] + dpR[i + 1][j + 1] + 1 == origLCS + 1) {
                        validChar[ch - 'a'] = true;
                        totalWays++;
                    }
                }
            }
        }

        return totalWays;
    }
}