class Solution {
    public int minPairSum(int[] nums) {
        
        Arrays.sort(nums);

        int i=0;
        int j = nums.length-1;

        int answer = 0;

        while(i<j)
        {

            int sum = nums[i] + nums[j];
            answer = Math.max(answer, sum);
            i++;
            j--;
        }

        return answer;
    }
}