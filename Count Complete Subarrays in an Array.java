class Solution {
    
    public int countCompleteSubarrays(int[] nums) {
        //
        //map
        int n=nums.length;

        HashMap<Integer,Integer>mp= new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            mp.put(nums[i], 1);
        }

        int count=0;
        for(int i=0;i<n;i++)
        {
            HashMap<Integer, Integer>mp2= new HashMap<>();
            for(int j=i;j<n;j++)
            {
                mp2.put(nums[j], 1);
                if( mp2.size()== mp.size() )
                {
                    count++;
                }
            }
            
        }
        return count;

        //sliding window.


    }
}
