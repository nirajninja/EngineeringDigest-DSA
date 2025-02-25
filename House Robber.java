class Solution {
    public int solve(int ind, int[] nums, int[] dp)
    {
        if(ind>= nums.length)
        {
            return 0;
        }

        if(dp[ind]!=-1) return dp[ind];
        //take
        dp[ind]= Math.max( nums[ind] + solve(ind+2, nums, dp), solve(ind+1, nums, dp));
        return dp[ind];
        //not take
    }
    public int rob(int[] nums) {
        int n=nums.length;
        int[] dp= new int[n];
        Arrays.fill(dp, -1);

        return solve(0, nums,dp);
    }
}
