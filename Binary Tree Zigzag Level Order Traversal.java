
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        	Queue<TreeNode> q= new LinkedList<>();
            List<List<Integer>>ans= new ArrayList<>();
            if(root==null)
            {
                return ans;
            }
            q.offer(root);
            int cnt=0;
            while(q.size()!=0)
            {
                int s=q.size();
                List<Integer>l= new ArrayList<>();
                while(s>0)
                {
                    TreeNode temp= q.peek();
                    q.poll();
                    l.add(temp.val);
                    if(temp.left!=null)
                    {
                        q.offer(temp.left);
                    }
                    if(temp.right!=null)
                    {
                        q.offer(temp.right);
                    }
                    s--;

                }
                if(cnt%2!=0)
                {
                    Collections.reverse(l);
                }   
                ans.add(l);
                cnt++;
            }
            return ans;


    }
}
