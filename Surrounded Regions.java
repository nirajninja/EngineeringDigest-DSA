class Solution {
    
    int[] x ={0,0,1,-1};
    int[] y ={1,-1,0,0};
    public void sol(int i, int j,char[][] board)
    {
        int n=board.length;
        int m=board[0].length;

        for(int k=0;k<4;k++)
        {
            int nx=i+x[k];
            int ny=j+y[k];

            if(nx>=0 && ny>=0 && nx<n && ny<m && board[nx][ny]=='O')
            {
                board[nx][ny]='Y';
                sol(nx, ny, board);
            }
        }
        return ;
        
    }
    
    public void solve(char[][] board) {

        int n=board.length;
        int m=board[0].length;
        for(int i=0;i<n;i++)
        {   
            if(board[i][0]=='O')
            {
                board[i][0]='Y';
                sol(i, 0, board);
            }
            if(board[i][m-1]=='O')
            {
                board[i][m-1]='Y';
                sol(i, m-1, board);
            }
        }

        for(int j=0;j<m;j++)
        {
            if(board[0][j]=='O')
            {
                board[0][j]='Y';
                sol(0, j, board);
            }

            if(board[n-1][j]=='O')
            {
                board[n-1][j]='Y';
                sol(n-1, j, board);
            }
        }

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(board[i][j]=='O')
                {
                    board[i][j]='X';
                }
            }
        }

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(board[i][j]=='Y')
                {
                    board[i][j]='O';
                }
            }
        }


        

    }
}
