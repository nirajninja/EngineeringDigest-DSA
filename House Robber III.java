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
    HashMap<TreeNode, Integer>mp= new HashMap<>();
    public int solve(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        if(mp.get(root)!=null)
        {
            return mp.get(root);
        }
        int amount=0;
        amount+= root.val;
        if(root.left!=null)
        {
            amount+= solve(root.left.left)+solve(root.left.right);
        }
        if(root.right!=null)
        {
            amount+= solve(root.right.left)+ solve(root.right.right);
        }
        int b=0;
        //exclude
        b=solve(root.left) + solve(root.right);
        mp.put( root, Math.max(amount, b) );
        return mp.get(root);
    }


    public int rob(TreeNode root) {
        return solve(root);
    }
}
