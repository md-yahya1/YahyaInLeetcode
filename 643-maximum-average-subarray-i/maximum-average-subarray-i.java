class Solution {
    public double findMaxAverage(int[] nums, int k) {

        int sum = 0;

        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        double maxAvg = (double) sum / k;

        int i = 0;
        int j = k;

        while (j < nums.length) {

            sum -= nums[i];
            sum += nums[j];

            maxAvg = Math.max(maxAvg, (double) sum / k);

            i++;
            j++;
        }

        return maxAvg;
    }
}