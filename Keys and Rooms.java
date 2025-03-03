//cute
class Solution {
    public void solve(int ind, List<List<Integer>>rooms, int[] vis)
    {
        int n=rooms.size();
        if(ind==n)
        {
            return;
        }
        vis[ind]=1;
        List<Integer>l= rooms.get(ind);
        for(Integer x:l)
        {
            if(vis[x]==0)
            {
                solve(x, rooms, vis);
            }
        }

    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        //normal DFS.
        int n=rooms.size();
        int[] vis= new int[n];
        Arrays.fill(vis, 0);
        solve(0, rooms, vis);

        for(int i=0;i<n;i++)
        {
            if(vis[i]==0)
            {
                return false;
            }
        }
        return true;



    }
}
