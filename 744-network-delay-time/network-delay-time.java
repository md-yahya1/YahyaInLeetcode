class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        int[] dist = new int[n+1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        for(int i=0; i<n-1; i++)
        {
            for(int[] time : times)
            {
                int x = time[0];
                int y = time[1];
                int w = time[2];

                if(dist[x] != Integer.MAX_VALUE && dist[y] > dist[x] + w)
                {
                    dist[y] = dist[x] + w;
                }
            }
        }


        int max = 0;
        for(int i=1; i<=n; i++)
        {
            if(dist[i] == Integer.MAX_VALUE)
            {
                return -1;
            }
            max = Math.max(max, dist[i]);
        }

        return max;
    }
}