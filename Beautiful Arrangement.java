class Solution {
    int cnt=0;

    public void solve(int ind, int[] arr)
    {   
        int n=arr.length;
        if(ind== arr.length)
        {
            for(int i=0;i<n;i++)
            {
               boolean a =false;
               if(arr[i]%(i+1)==0 || (i+1)%arr[i]==0)
               {
                a=true;
               }
               if(a==false)
               {
                return ;
               }
            }
            cnt++;
            return ;
        }
        
        for(int i=ind;i<n;i++)
        {

            int temp= arr[i];
            arr[i]= arr[ind];
            arr[ind]=temp;


            if(arr[i]%(i+1)==0 || arr[ind]%(ind+1)==0 || (ind+1)%arr[ind]==0 || (i+1)%arr[i]==0)
            {
            solve(ind+1, arr);

            }
            
            temp= arr[i];
            arr[i]= arr[ind];
            arr[ind]=temp;


        }
    }
    public int countArrangement(int n) {

      //check each permutation
      int[] arr= new int [n];
      for(int i=0;i<n;i++)
      {
        arr[i]=i+1;
      }

      solve(0, arr);
      return cnt;
    }
}
