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

    int ans=0;
    public void solve(TreeNode root, String s)
    {
        if(root==null)
        {
            return;
        }
        if(root!=null && root.left==null && root.right==null)
        {
            s+=String.valueOf( root.val);
            ans+=Integer.parseInt(s);
            return ;
        }

        solve(root.left,  s+ String.valueOf( root.val));
        solve(root.right,  s+ String.valueOf( root.val));

    }

    public int sumNumbers(TreeNode root) {
        
        String s="";
        solve(root, s);
        return ans;
    
    }
}
