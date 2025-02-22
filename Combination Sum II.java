class Solution {
    List<List<Integer>>ans = new ArrayList<>();
    public void solve(int ind, int[] candidates, int target, List<Integer>l)
    {
        if(ind== candidates.length)
        {
            if(target==0)
            {
                ans.add(new ArrayList<>(l));
            }
            return ;
        }

        //include
        if(candidates[ind]<=target)
        {
            l.add(candidates[ind]);
            solve(ind+1, candidates, target-candidates[ind],l);
            l.remove(l.size()-1); 
        }
        
        //exlude
        int in=ind+1;
        while( in <candidates.length  && candidates[in]==candidates[ind])
        {
            in++;
        }
        solve(in, candidates, target, l);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        //sort
        Arrays.sort(candidates);
        List<Integer>l= new ArrayList<>();
        solve(0, candidates, target, l);

        return ans;
    }
}
