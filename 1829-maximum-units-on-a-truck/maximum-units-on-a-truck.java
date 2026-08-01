class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        
        int ans = 0;
        int size = truckSize;

        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
    
        for(int box[] : boxTypes)
        {
            int minBox = Math.min(box[0], size);

            ans += minBox*box[1];
            size -= minBox;

            if(size == 0)
            {
                break;
            }

        }

        return ans;
    }
}