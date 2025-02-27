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
    public List<Integer> rightSideView(TreeNode root) {

        Queue<TreeNode>q= new LinkedList<>();

        List<Integer>l= new ArrayList<>();
        if(root==null)
        {
            return l;
        }
        q.offer(root);
        while(q.size()!=0)
        {
            int s=q.size();
            for(int i=0;i<s;i++)
            {
                TreeNode temp= q.peek();
                q.poll();
                if(i==s-1)
                {
                    l.add(temp.val);   
                }
                if(temp.left!=null)
                {
                    q.offer(temp.left);
                }

                if(temp.right!=null)
                {
                    q.offer(temp.right);
                }

            }
        }
        return l;

    }

}
