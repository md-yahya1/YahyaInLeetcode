class Solution {
    public int smallestIndex(int[] nums) {
        
        for(int i=0; i<nums.length; i++)
        {
            int target = 0;
            int num = nums[i];
            while(num > 0)
            {
                int digit = num%10;
                target += digit;
                num /= 10;
            }

            if(target == i)
            {
                return i;
            }
        }

        return -1;
    }
}