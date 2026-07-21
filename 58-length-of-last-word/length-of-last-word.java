class Solution {
    public int lengthOfLastWord(String s) {
        
        int lastIdx =0;
        int n=s.length()-1;

        while( n >=0 && s.charAt(n) == ' ')
        {
            n--;
        }

        lastIdx = n;

        while( n >=0 && s.charAt(n) != ' ')
        {
            n--;
        }

        return lastIdx - n ;
    }
}