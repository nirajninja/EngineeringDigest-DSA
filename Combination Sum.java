//getting things done bitch.
class Solution {
    List<List<Integer>>ans= new ArrayList<>();
    public void solve(int ind, int[] candidates, int target, List<Integer>l)
    {
        if(ind==candidates.length)
        {
            if(target==0)
            {
                System.out.println(l);
                ans.add(new ArrayList<Integer>(l));
            }
                            return ;

        }

            if(candidates[ind] <= target)
            {
                //include
                l.add(candidates[ind]);
                solve(ind, candidates, target-candidates[ind], l);
                l.remove(l.size()-1);
                //exclude
                }
            solve(ind+1, candidates, target, l);
            
            return ;
        }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<Integer>l= new ArrayList<>();
        solve(0, candidates, target, l);
        return ans;
        //
    }
}
