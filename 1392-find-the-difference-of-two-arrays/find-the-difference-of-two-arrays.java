class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> A = new HashSet<>();
        HashSet<Integer> B = new HashSet<>();

        List<List<Integer>> answer = new ArrayList<>();
  
        answer.add(new ArrayList<>());
        answer.add(new ArrayList<>());

        for(int no : nums1)
        {
            A.add(no);
        }

        for(int no : nums2)
        {
            B.add(no);
        }

        for(int no : A)
        {
            if(!B.contains(no))
            {
                answer.get(0).add(no);
            }
        }

        for(int no : B)
        {
            if(!A.contains(no))
            {
                answer.get(1).add(no);
            }
        }

        return answer;

    }
}