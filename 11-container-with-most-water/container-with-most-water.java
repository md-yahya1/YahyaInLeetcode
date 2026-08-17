class Solution {
    public int maxArea(int[] height) {
        
        int n = height.length;

        int right = n-1;
        int left = 0;

        int maxArea = 0;

        while(left < right)
        {
            int width = right - left;
            int h = Math.min(height[left] , height[right]);

            maxArea = Math.max(maxArea, width*h);

            if(height[left] < height[right])
            {
                left++;
            }
            else{
                right--;
            }
            
        }

        return maxArea;
    }
}