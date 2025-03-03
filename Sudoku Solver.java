class Solution {
    
    List<List<Character>>ch= new ArrayList<>();
    public boolean isPossible(int x, int y, char[][] board, char ch)
    {
        int n=board.length;
        int m=board[0].length;
        for(int i=0;i<n;i++)
        {
            if(board[i][y]==ch)
            {
                return false;
            }
        }
        for(int j=0;j<m;j++)
        {
            if(board[x][j]==ch)
            {
                return false;
            }

        }

        int nx=(x/3)*3;
        int ny=(y/3)*3;

        for(int i=nx;i<nx+3;i++)
        {   
            for(int j=ny;j<ny+3;j++)
            {
                if(board[i][j]==ch) return false;
            }

        }

        return true;
    } 
    
    public boolean solve(int i, int j, char[][] board)
    {

        int n=board.length;
        int m=board[0].length;
        if(i==n)
        {
            return true;
        }
        int nx=0,ny=0;

        if(j==m-1)
        {
            nx=i+1;
            ny=0;
        }
        else{
            nx=i;
            ny=j+1;
        }
        if(board[i][j]!='.')
        {
            return solve(nx, ny, board);

        }
        else{
            for(char k='1';k<='9';k++)
            {
                if(isPossible(i,j, board,k))
                {
                    board[i][j]= k;
                    if(solve(nx, ny, board))
                    {
                        return true;
                    }
                    board[i][j]='.';
                    
                }
            }
        }
        return false;
    }
    public void solveSudoku(char[][] board) {

            solve(0,0,board);
      //  
    }
}
