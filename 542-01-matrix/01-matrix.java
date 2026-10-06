class Solution {
    public int[][] updateMatrix(int[][] mat) {
        
        int n = mat.length;
        int m = mat[0].length;

        int[][] level = new int[n][m];

        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {

                if(mat[i][j] == 0)
                {
                    q.add(new int[]{i, j});
                }
            }
        }

        int[][] dir = {
            {0, 1},
            {1, 0},
            {-1, 0},
            {0, -1}
        };

        while(!q.isEmpty())
        {
            int[] top = q.peek();
            q.remove();

            int row = top[0];
            int col = top[1];

            for(int i=0; i<4; i++)
            {
                int nr = row + dir[i][0];
                int nc = col + dir[i][1];

                if(nr >= 0 && nc >= 0 && nr < n && nc < m && mat[nr][nc] == 1)
                {
                    mat[nr][nc] = 0;
                    level[nr][nc] = level[row][col] + 1;

                    q.offer(new int[]{nr, nc});
                }
            }
        }

        return level;
    }
}