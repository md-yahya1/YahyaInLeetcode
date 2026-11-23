class Solution {
    public int lengthOfLastWord(String s) {
        
        int LastIndex = 0;
        int n = s.length() - 1;

        while(n >= 0 && s.charAt(n) == ' ')
        {
            n--;
        }

        LastIndex = n;

        while(n >= 0 && s.charAt(n) != ' ')
        {
            n--;
        }

        return LastIndex - n;
    }
}