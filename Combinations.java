class Solution {
    
    List<List<Integer>> ans= new ArrayList<>();
    public void solve(int[] arr, int k , int ind, List<Integer>l)
    {
        if(ind== arr.length)
        {
            if(l.size()==k)
            {
                ans.add(new ArrayList<>(l));
            }
           return ;
        }

        l.add(arr[ind]);
        solve(arr, k, ind+1, l);
        l.remove(l.size() - 1);
        solve(arr, k,ind+1, l);

        return ;
    }

    public List<List<Integer>> combine(int n, int k) {
        
        int[] arr =new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=i+1;
        }
        List<Integer>l= new ArrayList<>();
        solve(arr, k, 0 , l);
        return ans;
    }
}
