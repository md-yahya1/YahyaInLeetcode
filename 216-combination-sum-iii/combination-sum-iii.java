class Solution {
    List<List<Integer>> answer = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        

        recursion(k, n, 1, new ArrayList<>());

        return answer;
    }

    public void recursion(int k, int n, int index,ArrayList<Integer> current)
    {

        if(k == 0 && n == 0)
        {
            answer.add(new ArrayList<>(current));
            return;
        }

        for(int i = index; i<10; i++)
        {
            if(i > n || k<= 0)
            {
                break;
            }
            current.add(i);
            recursion(k-1 ,n-i ,i+1 ,current );
            current.remove(current.size()-1);
        }
    }
}