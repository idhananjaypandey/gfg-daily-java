// Longest Matching in Dictionary with Removals

class Solution {
    public String findLongestWord(String s, List<String> d) {
        String result = "";
        char[] sArr = s.toCharArray();
        
        for (String word : d) {
            int wordLen = word.length();
            int resLen = result.length();
            
            if (wordLen < resLen) {
                continue;
            }
            if (wordLen == resLen && word.compareTo(result) >= 0) {
                continue;
            }
            
            if (isSubsequence(word, sArr)) {
                result = word;
            }
        }
        return result;
    }

    private boolean isSubsequence(String word, char[] sArr) {
        int i = 0, j = 0;
        int wLen = word.length();
        int sLen = sArr.length;
        
        while (i < wLen && j < sLen) {
            if (word.charAt(i) == sArr[j]) {
                i++;
            }
            j++;
        }
        return i == wLen;
    }
}