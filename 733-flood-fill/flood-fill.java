class Solution {

    public void dfs(int[][] image, int i, int j, int color, int Src)
    {
        if(i < 0 || j < 0 || i >= image.length || j >= image[0].length)
        {
            return;
        }

        if(Src != image[i][j])
        {
            return;
        }

        image[i][j] = color;

        dfs(image, i+1, j, color, Src);
        dfs(image, i, j+1, color, Src);
        dfs(image, i-1, j, color, Src);
        dfs(image, i, j-1, color, Src);
        return;
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        int Src = image[sr][sc];
        if(Src != color)
        {
            dfs(image, sr, sc, color, Src);
        } 

        return image;
    }
}