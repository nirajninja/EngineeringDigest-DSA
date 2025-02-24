class Solution {
    int cnt=0;
    public int solve(int i, int j, int m, int n, int[][]dp )
    {   
        //move down
        if(i==m-1 || j==n-1)
        {
            cnt=cnt+1;
            return 1;
        }
        
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }

        //move right;
        dp[i][j] = solve(i+1, j, m, n,dp) + solve(i, j+1, m, n,dp);      
        return dp[i][j]; 
    }
    
    public int uniquePaths(int m, int n) 
    {
        int[][] dp = new int[m][n];

        for (int i = 0;i<m;i++)
        {
            Arrays.fill(dp[i], -1);
        }
        return solve(0,0, m,n, dp);    
    }
}
