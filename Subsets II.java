class Solution {
    
    List<List<Integer>>ans= new ArrayList<>();
    public void solve(int ind, int[] nums, List<Integer>l)
    {

        if(ind==nums.length)
        {
            ans.add(new ArrayList<>(l));
            return ;
        }

        //include exlude

        l.add(nums[ind]);
        solve(ind+1, nums, l);
        l.remove(l.size()-1);

        int in= ind+1;
        while(in< nums.length && nums[in]== nums[ind])
        {
            in++;
        }
        solve(in, nums, l);

    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);
        List<Integer>l= new ArrayList<>();
        solve(0, nums, l);
        return ans;

    }
}
