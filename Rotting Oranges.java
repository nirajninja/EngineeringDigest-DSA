class Solution {
    
    class Pair{
        int i;
        int j;
        Pair(int i, int j)
        {
            this.i=i;
            this.j=j;
        }
    }
    public int orangesRotting(int[][] grid) {
        //normal BFS.

            int n=grid.length;
            int m=grid[0].length;
            Queue<Pair>q= new LinkedList<>();
            int cnt=0;
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<m;j++)
                {

                    if(grid[i][j]==2)
                    {
                        q.offer(new Pair(i,j));
                    }

                    if(grid[i][j]==1)
                    {
                        cnt++;
                    }

                }

            }

            if(cnt==0)
            {
                return 0;
            }

            int time=0;

            int[] x={0,0,1,-1};
            int[] y={1,-1,0,0};
            while(q.size()!=0)
            {
                time++;
                int s=q.size();
                for(int i=0;i<s;i++)
                {
                    Pair p=q.peek();
                    q.poll();

                     int I=p.i;
                     int J=p.j;

                     for(int k=0;k<4;k++)
                     {
                        int nx=I+x[k];
                        int ny=J+y[k];

                        if(nx>=0 && ny>=0 && nx<n && ny<m && grid[nx][ny]==1)
                        {
                            cnt--;
                            grid[nx][ny]=2;
                            q.offer( new Pair(nx,ny));
                        }
                     }

                     if(cnt==0)
                     {
                        return time;
                     }  

                }
            }
            return -1;

    }
}
