class Solution {
    public String convert(String s, int numRows) {
        
        if(numRows == 1 || numRows >= s.length())
        {
            return s;
        }

        StringBuilder str[] = new StringBuilder[numRows];

        for(int i=0; i<numRows; i++)
        {
            str[i] = new StringBuilder();
        }

        int turn = 0;
        int index = 0;

        for(int i=0; i<s.length(); i++)
        {
            str[index].append(s.charAt(i));
            if(turn == 0)
            {
                index++;
                if(index == numRows)
                {
                    turn = 1;
                    index -=2;
                }

            }
            else{

                index--;
                if(index == -1)
                {
                    turn = 0;
                    index += 2;

                }
            }
        }

        StringBuilder ans = new StringBuilder();

        for(int i=0; i<str.length; i++)
        {
            ans.append(str[i]);
        }


        return ans.toString();
    }
}