class Solution {
    List<List<Integer>>ans= new ArrayList<>();

    public void solve(int[] nums , int ind)
    {
        if( ind == nums.length)
        {
            
            List<Integer> temp= Arrays.stream(nums) .boxed().collect(Collectors.toList()); 
            ans.add( temp);
            return ;
        }

        for(int i=ind;i<nums.length;i++)
        {
             //Collections.swap(nums, ind, i);

             int a= nums[ind];
             nums[ind]=nums[i];
             nums[i]= a;

             solve(nums, ind+1);
             a=nums[ind];
             nums[ind]= nums[i];
             nums[i]=a;
             //Collections.swap(nums, i, ind);
            
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {

        //swap karna hota hai, ind, aur index ko.
        //two times.

        solve(nums, 0);
        return ans;

    }
}
