class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;

        int j = 0;
        int k = 0;

        while (i < nums.length) {
            nums[k] = nums[i];
            while (j < nums.length && nums[j] == nums[i]) {
                j++;
            }

            i = j;
            k++;
        }

        return k;
    }
}