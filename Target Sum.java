class Solution {
    int cnt=0;
    public void solve( int ind, int[] nums, int target, int sum ) 
    {
        if(ind==nums.length)
        {   if(target==sum)
            {
                cnt++;
            }
            return ;    
        }
        solve( ind+1, nums, target, sum + (-1* nums[ind]) );
        solve( ind+1, nums , target, sum + nums[ind] );
    
    }  
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        solve(0, nums, target, sum);
        return cnt;
    }

}Target SumTarget SumTarget Sum
