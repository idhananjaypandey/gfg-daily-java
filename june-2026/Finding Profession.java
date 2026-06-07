// Finding Profession

class Solution {
    public static String profession(int level, int pos) {
       int count = Integer.bitCount(pos - 1);
        
        // If the count of 1s is odd, it's a Doctor. If even, it's an Engineer.
        return (count % 2 != 0) ? "Doctor" : "Engineer";
    }

 
}