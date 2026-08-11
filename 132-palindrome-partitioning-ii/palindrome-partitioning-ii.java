class Solution {
    public int minCut(String s) {

        int dp[] = new int[s.length()];
        Arrays.fill(dp, -1);
        
        return recur(0, s, dp) - 1;
    }

    public int recur(int index, String s, int[] dp)
    {
        if(index == s.length())
        {
            return 0;
        }
        if(dp[index] != -1)
        {
            return dp[index];
        }

        int min = 2000;

        for(int i=index; i<s.length(); i++)
        {
            if(isPalindrome(s, index, i))
            {
                int pieces = 1 +  recur(i+1, s, dp);
                
                min = Math.min(min, pieces);
            }
        }

        dp[index] = min;
        return dp[index] ;
    }

    public boolean isPalindrome(String s, int start, int end)
    {
        while(start <= end)
        {
            if(s.charAt(start++) != s.charAt(end--))
            {
                return false;
            }
        }
        return true;
    }
}