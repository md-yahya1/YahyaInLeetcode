class Solution {

    public int recur(int index, int[] cost, int[] dp)
    {
        if(cost.length <= index)
        {
            return 0;
        }

        if(dp[index] != -1)
        {
            return dp[index];
        }

        int opt1 = cost[index] + recur(index + 1, cost, dp);
        int opt2 = cost[index] + recur(index + 2, cost, dp);

        dp[index] = Math.min(opt1, opt2);

        return dp[index];
    }
    public int minCostClimbingStairs(int[] cost) {
        
        int n = cost.length;
        int[] dp = new int[n];

        Arrays.fill(dp, -1);
        int ans = Math.min(recur(0, cost, dp), recur(1, cost, dp));

        return ans;
    }
}