class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {

        List<Integer> ans = new ArrayList<>();

        int col = matrix.length;
        int row = matrix[0].length;

        List<Integer> minRowList = new ArrayList<>();
        for(int i=0; i<col; i++)
        {
            int minRow = Integer.MAX_VALUE;

            for(int j=0; j<row; j++)
            {
                minRow = Math.min(minRow, matrix[i][j]);
            }
            minRowList.add(minRow);
        }        

        List<Integer> maxColList = new ArrayList<>();

        for(int i=0; i<row; i++)
        {
            int colMax = Integer.MIN_VALUE;

            for(int j=0; j<col; j++)
            {
                colMax = Math.max(colMax, matrix[j][i]);
            }
            maxColList.add(colMax);
        }

        for(int i=0; i<col; i++)
        {
            for(int j=0; j<row; j++)
            {
                if(matrix[i][j] == minRowList.get(i) && matrix[i][j] == maxColList.get(j))
                {
                    ans.add(matrix[i][j]);
                }
            }
        }

        return ans;
    }
}