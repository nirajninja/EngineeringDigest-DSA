class Solution {
    
    int[] x={1,-1,0,0};
    int[] y={0,0,1,-1};
    public boolean solve(int ind, int i, int j, char[][]board,String word, int[][] vis)
    {
        if(ind== word.length())
        {
            return true;
        }
        int n=board.length;
        int m=board[0].length;
        for(int k=0;k<4;k++)
        {
            Integer nx= i+x[k];
            Integer ny=j+y[k];

            if(nx>=0 && ny>=0 && nx<n && ny<m && vis[nx][ny]==0 && board[nx][ny]==word.charAt(ind)) 
            {
               vis[i][j]=1;
                if( solve(ind+1, nx,ny,board, word, vis))
                {
                    return true;
                }
                vis[i][j]=0;
            }
        }
        return false;
    }

    public boolean exist(char[][] board, String word) {
        int n=board.length;
        int m=board[0].length;

        //List<List<Integer>>vis= new ArrayList<>();
        int[][] vis=new int[n][m];
        for(int i=0;i<n;i++)
        {
            List<Integer>l= new ArrayList<>();
            for(int j=0;j<m;j++)
            {
                vis[i][j]=0;
            }
           // vis.add(l);
        }    

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(word.charAt(0)== board[i][j])
                {
                    if(solve(1,i,j,board, word, vis))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
