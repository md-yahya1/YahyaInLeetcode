class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        int INF = (int) (1e9);
        int[] cost = new int[n];
        Arrays.fill(cost, INF);

        cost[src] = 0;
        for (int i = 0; i <= k; i++) {
            int[] temp = cost.clone();
            for (int[] flight : flights) {
                int u = flight[0];
                int v = flight[1];
                int w = flight[2];

                if (cost[u] != INF && temp[v] > cost[u] + w) {
                    temp[v] = cost[u] + w;
                }
            }

            cost = temp;
        }

        return cost[dst] == INF ? -1 : cost[dst];
    }
}