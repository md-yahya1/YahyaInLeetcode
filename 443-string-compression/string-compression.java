class Solution {
    public int compress(char[] chars) {
        
        int n = chars.length;

        int i=0; 
        int j=0;

        if(n == 1)
        {
            return 1;
        }

        while( i < n)
        {
            int count = 1;
            char charac = chars[i];

            while(i+1 < n && chars[i] == chars[i+1])
            {
                count++;
                i++;
            }

            if(count == 1)
            {
                chars[j++] = charac; // one char there no need for no
            }
            else{
                // duplicates exists need an no
                if(count > 1)
                {
                    chars[j++] = charac;
                    String c = count + "";
                    for(int k=0; k<c.length(); k++)
                    {
                        chars[j++] = c.charAt(k);
                    }
                }
            }
            i++;

            
        }

        return j;
    }
}