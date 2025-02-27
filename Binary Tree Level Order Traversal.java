/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    


    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        List<List<Integer>>ans= new ArrayList<>();
        if(root==null)
        {
            return ans;
        }
        while( q.size() != 0 )
        {
            int s=q.size();
            int size=s;
             List<Integer>l = new ArrayList<>();
            while(size>0)
            {
               
                
                    TreeNode temp = q.peek();
                    q.poll();

                    l.add( temp.val );

                    if(temp.left!=null)
                    {
                        q.offer(temp.left);
                    }
                    if(temp.right!=null)
                    {
                        q.offer(temp.right);
                    }
                size--;
            }
            ans.add(l);
        }
        return ans;
    }
}
