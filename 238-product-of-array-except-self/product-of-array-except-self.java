class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int n = nums.length;
        int[] arrProd = new int[n];

        int prefix[] = new int[n];
        int suffix[] = new int[n];

        prefix[0] = nums[0];
        suffix[n-1] = nums[n-1];

        for(int i=1; i<n-1; i++)
        {
            prefix[i] = nums[i]*prefix[i-1];
            suffix[n - i - 1] = nums[n - i - 1]*suffix[n - i];
        }

        arrProd[0] = suffix[1];
        arrProd[n - 1] = prefix[n - 2];

        for(int i=1; i<n-1; i++)
        {
            arrProd[i] = prefix[i-1] * suffix[i+1];
        }

        return arrProd;
    }
}