class Solution {

    public void recur(int index, int[] nums, List<List<Integer>> answer, List<Integer> curr)
    {
        if(index == nums.length)
        {
            answer.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[index]);
        recur(index+1, nums, answer, curr);
        curr.remove(curr.size() - 1);

        recur(index+1, nums, answer, curr);
    }
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> answer = new ArrayList<>();

        recur(0, nums, answer, new ArrayList<>());

        return answer;
    }
}