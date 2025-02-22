//nqueen problem
class Solution {

    List<List<String>>ans= new ArrayList<>();
    public Boolean isValid(int row, int col, int n, List<String>l)
    {
        for( int i=0;i<row;i++ )
        {
            if( l.get(i).charAt(col)=='Q')
            {
                return false;
            }
        }
        int i=row, j=col;
        while(i>=0 && j<n  ) 
        {
            //Character ch=l.get(i).charAt(col); 
            if(l.get(i).charAt(j)=='Q' && i!=row && j!=col)
            {
                return false;
            }
            i--;
            j++;
       }

       i= row;
       j=col;
       while(i>=0 && j>=0 )
       {
            //Character ch=l.get(i).charAt(col); 
            if(l.get(i).charAt(j)=='Q' && i!=row && j!=col)
            {
                return false;       
            }
        i--;
        j--;
       }
       return true;
    }

    public void solve(int row, int n, List<String>l)
    {
        if(row==n)
        {

            ans.add(new ArrayList<>(l));
            return;
        }
        for(int i=0;i<n;i++)
        {
            //isValid.
            if(isValid(row, i, n, l))
            {
                // l.get(row).setCharAt(i, 'Q');
                // solve(row+1, n , l);
                // l.get(row).setCharAt(i, '.'); // charAt(i)='.';

                StringBuilder sb = new StringBuilder(l.get(row));
                sb.setCharAt(i, 'Q');
                l.set(row, sb.toString());

                // Recur for the next row
                solve(row + 1, n,l);

                // Backtrack: remove the queen
                sb.setCharAt(i, '.');
                l.set(row, sb.toString());
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        String s="";
        for(int i=0;i<n;i++)
        {
            s+=".";
        }
        List<String>l= new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            l.add(s);
        }
        solve(0, n, l);
        return ans;
    }
}
