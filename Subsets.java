class Solution {

    List<List<Integer>>ans= new ArrayList<>();
    public void solve(int ind, int[] nums, List<Integer>l)
    {
        if(ind== nums.length)
        {   
            ans.add(new ArrayList<>(l));
            return ;
        }
        //incldude
        l.add(nums[ind]);
        solve(ind+1, nums, l);
        l.remove(l.size()-1);
        //exclude
        solve(ind+1, nums, l);
        return ;
    }

    public List<List<Integer>> subsets(int[] nums) {
        //possible subset.
        List<Integer>l= new ArrayList<>();
        solve(0, nums, l);
        return ans;
    }
}
