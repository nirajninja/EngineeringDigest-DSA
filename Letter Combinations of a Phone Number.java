class Solution {
    
      
     List<String> ans= new ArrayList<>();
    public void solve(String digits,int ind, String a, String[] arr )
    {
        if(ind== digits.length())
        {
            ans.add(a);
            return;
        }

        char inde= digits.charAt(ind);
        int index= Character.getNumericValue(inde);  
        String word = arr[index];

        for(int i=0;i<word.length();i++)
        {
            solve(digits, ind+1, a+word.charAt(i),arr );
        }
        return ;

    }

    public List<String> letterCombinations(String digits) {        
        String[]  arr= {"","", "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        String a="";
        if(digits.length()==0)
        {
            return ans;
        }
        solve(digits, 0,a,arr );
        return ans;

     
    }
}
