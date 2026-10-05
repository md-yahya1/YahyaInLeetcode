class Solution {
    public int scoreOfParentheses(String s) {
        
        Stack<Integer> st = new Stack<>();

        st.push(0);
        for(int i=0; i<s.length(); i++)
        {
            char ch = s.charAt(i);
            if(ch == '(')
            {
                st.push(0);
            }
            else{

                int current = st.pop();

                if(current == 0)
                {
                    current = 1;
                }
                else{
                    current *= 2;
                }

                st.push(st.pop() + current);

            }

        }
    return st.peek();
    }
}