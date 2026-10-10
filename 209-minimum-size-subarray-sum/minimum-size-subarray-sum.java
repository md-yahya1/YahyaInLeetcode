class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int right = 0;
        int left = 0;

        int answer = (int)1e6;
        int sum = 0;

        while(right < nums.length)
        {
            sum += nums[right];
            while(left<=right && target <= sum)
            {
                answer = Math.min(answer, right - left + 1);
                sum -= nums[left];
                left++;
            }    
            right++;
        }

        return answer == (int)1e6 ? 0 : answer;
    }
}