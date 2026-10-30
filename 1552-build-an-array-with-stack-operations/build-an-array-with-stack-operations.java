class Solution {
    public List<String> buildArray(int[] target, int n) {
        

        List<String> answer = new ArrayList<>();
        int j = 0;

        for(int i=1; i<=n && j < target.length;i++)
        {
            answer.add("Push");
            if(i == target[j])
            {
                j++;  
            }
            else{
                answer.add("Pop");
            }
        }

        return answer;
    }

}