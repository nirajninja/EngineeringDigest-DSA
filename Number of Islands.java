class Solution {
    int[] x={0,0,1,-1};
    int[] y={1,-1,0,0};
    public void solve(int i, int j, char[][] grid)
    {
        int n=grid.length;
        int m=grid[0].length;

        for(int k=0;k<4;k++)
        {
            int nx=i+x[k];
            int ny=j+y[k];

            if(nx>=0 && ny>=0 && nx<n && ny<m && grid[nx][ny]=='1')
            {
                grid[nx][ny]='0';
                solve(nx,ny, grid);
            }
        }

    }
    public int numIslands(char[][] grid) {
        //normal DFS.
        int cnt=0;   
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]=='1')
                {
                    cnt++;
                    grid[i][j]='0';
                    solve(i,j, grid);
                }
            }
        }    
        return cnt;
    }
}
