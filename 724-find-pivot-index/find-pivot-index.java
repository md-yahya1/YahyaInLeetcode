class Solution {
    public int pivotIndex(int[] nums) {
        
        int leftSum = 0;
        int rightSum = 0;
        int totalSum = 0;

        for(int no : nums)
        {
            totalSum += no;
        }

        for(int i=0; i<nums.length; i++)
        {
            rightSum = totalSum - leftSum - nums[i];
            if(rightSum == leftSum)
            {
                return i;
            }
            leftSum += nums[i];
        }

        return -1;
    }
}