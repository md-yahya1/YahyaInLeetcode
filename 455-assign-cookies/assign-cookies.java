class Solution {
    public int findContentChildren(int[] g, int[] s) {
        
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0;
        int j = 0;

        while(i < g.length && j < s.length)
        {
            if(s[j] >= g[i])
            {
                i = i + 1;
            }
            j = j + 1;
        }

        return i;

    }
}