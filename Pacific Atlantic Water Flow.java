class Solution {

    int[] X={0,0,1,-1};
    int[] Y={1,-1,0,0};
    public void solve(int i,int j, int[][] heights, int[][] vis)
    {
        int n=heights.length;
        int m=heights[0].length;
        vis[i][j]=1;

        for(int k=0;k<4;k++)
        {
            int nx=i+X[k];
            int ny=j+Y[k];

            if(nx>=0 && ny>=0 && nx<n && ny<m && vis[nx][ny]==0 && heights[i][j]<=heights[nx][ny])
            {
                vis[nx][ny]=1;
                solve(nx, ny, heights, vis);
            }
        }
        return ;
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
     //
     //use two traversal , one for pacific border , one for atlantic border.

    int n=heights.length;
    int m=heights[0].length;
    int[][] pac= new int[n][m];
    int [][] alt= new int[n][m];
    for(int i=0;i<n;i++)
    {
        Arrays.fill(pac[i],0 );
        Arrays.fill(alt[i] , 0);
    }

    for(int i=0;i<n;i++)
    {
        solve(i, 0, heights, pac); 
    }
    for(int j=0;j<m;j++)
    {
        solve(0, j, heights, pac);
    }
    for(int i=0;i<n;i++)
    {
        solve(i, m-1, heights, alt);
    }
    for(int j=0;j<m;j++)
    {
        solve( n-1,j , heights, alt);
    }    
    List<List<Integer>>ans= new ArrayList<>();

    for(int i=0;i<n;i++)
    {
        for(int j=0;j<m;j++)
        {
            if(pac[i][j]==1 && alt[i][j]==1)
            {
                List<Integer>l= new ArrayList<>();
                l.add(i);
                l.add(j);
                ans.add(l);
            }
        }
    }
    return ans;

    }
}
