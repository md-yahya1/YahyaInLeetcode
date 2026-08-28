class Solution {
    public void dfs(int[][] isConnected, boolean vis[], int node)
    {
        vis[node] = true;

        for(int i=0; i<isConnected.length; i++)
        {
            if(!vis[i]  && isConnected[node][i] == 1)
            {
                dfs(isConnected, vis, i);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        
        int n = isConnected.length;
        int count = 0;
        boolean vis[] = new boolean[n];

        for(int i=0; i<n; i++)
        {
            if(!vis[i])
            {
                dfs(isConnected, vis, i);
                count++;
            }
        }

        return count;
    }
}