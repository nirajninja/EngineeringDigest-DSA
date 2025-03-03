class Solution {
    public boolean isValid(String s) {
       //
       Stack<Character>st= new Stack<>();
       for(int i=0;i<s.length();i++)
       {
        Character ch= s.charAt(i);

        if(ch=='(' || ch=='[' || ch=='{')
        {
            st.push(ch);
        }
        else{
            if(st.size()==0)
            {
                return false;
            }else if(st.size()!=0)
            {
                Character tp= st.peek();
                st.pop();
                if(ch==')' && tp!='(')
                {
                        return false;
                }
                else if(ch==']' && tp!='[')
                {
                    return false;
                }
                else if(ch=='}' && tp!='{')
                {
                    return false;
                }
            }
        }
       }
        if(st.size()==0)
        {
            return true;
        }
        return false;
       
    }
}
