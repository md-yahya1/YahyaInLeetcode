class Solution {
    public int orangesRotting(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        int countFresh = 0;

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(grid[i][j] == 2)
                {
                    
                    q.offer(new int[]{i, j, 0});
                    vis[i][j] = 2;
                }
                else{
                    vis[i][j] = 0;
                }

                if(grid[i][j] == 1)
                {
                    countFresh++;
                }
            }
        }

        int time = 0;
        int[] drow = {-1, 0, +1, 0};
        int[] dcol = {0, +1, 0, -1};

        while(!q.isEmpty())
        {
            int row = q.peek()[0];
            int col = q.peek()[1];
            int t = q.peek()[2];

            time = Math.max(time, t);
            q.poll();

            for(int i=0; i<4; i++)
            {
                int r = row + drow[i];
                int c = col + dcol[i];

                if(r>=0 && c>=0 && r < n && c < m && vis[r][c] != 2 && grid[r][c] == 1)
                {
                    q.offer(new int[]{r, c, t+1});
                    vis[r][c] = 2;
                    countFresh--;
                }
            }
        }
        if(countFresh != 0)
        {
            return -1;
        }
        return time;
    }
}