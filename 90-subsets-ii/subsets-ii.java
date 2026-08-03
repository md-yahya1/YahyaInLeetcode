class Solution {
    public void recur(int index, int[] nums, List<List<Integer>> answer, List<Integer> curr)
    {
        
        answer.add(new ArrayList<>(curr));
        
        
        for(int i=index; i<nums.length; i++)
        {
            if(index < i && nums[i] == nums[i-1])
            {
                continue;
            }

            curr.add(nums[i]);
            recur(i+1, nums, answer, curr);
            curr.remove(curr.size() - 1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();

        Arrays.sort(nums);

        recur(0, nums, answer, new ArrayList<>());

        return answer;
    }
}