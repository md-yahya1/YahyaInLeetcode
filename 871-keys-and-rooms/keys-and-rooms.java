class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        boolean[] vis = new boolean[rooms.size()];

        dfs(0, rooms, vis);

        for(int i=0; i<rooms.size(); i++)
        {
            if(!vis[i])
            {
                return false;
            }
        }

        return true;
    }

    public void dfs(int room, List<List<Integer>> rooms, boolean vis[])
    {
        vis[room] = true;

        for(int key : rooms.get(room))
        {
            if(!vis[key])
            {
                dfs(key, rooms, vis);
            }
        }

    }
}