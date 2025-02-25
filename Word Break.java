class Solution {
    
    public boolean solve(int ind, String s, List<String>wordDict, HashMap<String, Integer>mp ,HashMap<Integer, Boolean> dp)
    {
        if(ind== s.length())
        {
            return true;
        }

        if(dp.get(ind)!=null)
        {
            return dp.get(ind);
        }

        for(int i=ind+1;i<s.length();i++)
        {   
            String ss= s.substring(ind, i+1);
            if(mp.get(ss)!=null)
            {
                if(solve(i+1, s, wordDict, mp,dp))
                {
                    dp.put(ind , true);
                    return dp.get(ind);
                }
            }
        }
        dp.put(ind, false);
        return dp.get(ind);
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        
        HashMap<Integer, Boolean>dp= new HashMap<>();
        HashMap<String, Integer>mp = new HashMap<>();
        int n=s.length();
        for(int i=0;i<wordDict.size();i++)
        {
            mp.put(wordDict.get(i), 1);
        }

        return solve(0, s, wordDict, mp, dp);

    }
}
