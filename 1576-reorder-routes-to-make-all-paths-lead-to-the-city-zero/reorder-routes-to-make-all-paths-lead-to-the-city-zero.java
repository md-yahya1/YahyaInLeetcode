class Solution {

    public int dfs(List<List<Integer>> adj, boolean[] vis, int from)
    {
        vis[from] = true;
        int change = 0;

        for(int next : adj.get(from))
        {
            int neighbour = Math.abs(next);

            if(vis[neighbour])
            {
                continue;
            }

            if(next > 0)
            {
                change++;
            }

            change += dfs(adj, vis, neighbour);
        }

        return change; 
    }
    public int minReorder(int n, int[][] connections) {
        
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i=0; i<n; i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int[] edge : connections)
        {
            int from = edge[0];
            int to = edge[1];

            adj.get(from).add(to);

            adj.get(to).add(-from);

        }

        return dfs(adj, new boolean[n], 0);
    }
}