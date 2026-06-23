// Maximum Number of People Defeated

class Solution {
    public int maxPeopleDefeated(int p) {
        int count = 0;
        int i = 1;
        
        while (true) {
            // Calculate the strength needed for the current person
            long strengthRequired = (long) i * i; 
            
            if (p >= strengthRequired) {
                p -= strengthRequired;
                count++;
                i++;
            } else {
                break;
            }
        }
        
        return count;
    }
}