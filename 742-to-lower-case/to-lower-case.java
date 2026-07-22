class Solution {
    public String toLowerCase(String s) {
        
        String res = "";

        for(int i=0; i<s.length(); i++)
        {
            char ch = s.charAt(i);
            
            if(ch >= 65 && ch <= 90)
            {
                res += (char)(ch + 32);
            }
            else{
                res += ch;
            }
        }
        return res;
    }
}