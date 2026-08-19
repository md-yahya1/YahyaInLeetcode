class Solution {
    public int longestOnes(int[] nums, int k) {
        

        int left = 0;
        int right = 0;

        int zero_count = 0;
        int maxZero = 0;

        while(right < nums.length)
        {
            if(nums[right] == 0)
            {
                zero_count++;
            }

            while(zero_count > k && right >= left)
            {
                if(nums[left] == 0)
                {
                    zero_count--;
                }
                left++;
            }

            maxZero = Math.max(maxZero, right - left + 1);
            right++;
        }

        return maxZero;
    }
}