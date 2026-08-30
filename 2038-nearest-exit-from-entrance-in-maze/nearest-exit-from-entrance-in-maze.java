class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        
        int m = maze.length;
        int n = maze[0].length;

        Queue<int[]> q = new LinkedList<>();
        maze[entrance[0]][entrance[1]] = '+';
        int steps = 0;

        q.add(new int[]{entrance[0] ,entrance[1]});

        int[][] dir = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        while(!q.isEmpty())
        {
            int size = q.size();

            steps++;

            while(size-- > 0)
            {
                int[] top = q.remove();

                for(int i=0; i<4; i++)
                {
                    int r = top[0] + dir[i][0];
                    int c = top[1] + dir[i][1];

                    if(r >= m || c >= n || r < 0 || c < 0 || maze[r][c] != '.')
                    {
                        continue;
                    }

                    if(r == m-1 || r == 0 || c == n-1 || c == 0)
                    {
                        return steps;
                    }

                    maze[r][c] = '+';
                    q.add(new int[]{r,c});

                }
            }
        }

        return -1;

    }
}