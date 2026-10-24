class Solution {
    public int numberOfSpecialChars(String word) {
        
        int[] lowerCase = new int[26];
        int[] upperCase = new int[26];
        
        int ans = 0;
        
        Arrays.fill(lowerCase, -1);
        Arrays.fill(upperCase, -1);
        
        
        for(int i=0; i<word.length(); i++)
        {
            char ch = word.charAt(i);
            if(ch >= 'a' && ch <= 'z')
            {
                int no = ch - 'a';
                
                lowerCase[no] = i;
                
            }
            else{
                if(upperCase[ch-'A'] == -1)
                {
                    upperCase[ch-'A'] = i;
                }
                
            }
        }
        
        for(int i=0; i<26; i++)
        {
            if(upperCase[i] != -1 && lowerCase[i] != -1 && upperCase[i] > lowerCase[i])
            {
                ans++;
            }
        }
        
        return ans;
    }
}