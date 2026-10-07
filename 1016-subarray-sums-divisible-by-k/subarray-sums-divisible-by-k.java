class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);
        int answer = 0;
        int sum = 0;

        for(int i=0; i<nums.length; i++)
        {

            sum += nums[i];

            sum = sum%k;

            if(sum < 0)
            {
                sum += k; // -3%5 = 2%5 where k=5
            }
            answer += map.getOrDefault(sum%k, 0);
            map.put(sum%k, map.getOrDefault(sum%k, 0) + 1);
        }

        return answer;
    }
}