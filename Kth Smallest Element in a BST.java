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
    public int count(TreeNode root)
    {
        if(root==null) return 0;

        return 1+ count(root.left)+ count(root.right);
    }

    public TreeNode solve(TreeNode root, int k)
    {
        if(root==null) return null;
        int le= count(root.left);
        //int right=count(root.right);

        if(le+1==k)
        {
            return root;
        }

        if(le>=k)
        {
           return solve(root.left, k);
        }

        if(le+1<k)
        {
           return solve(root.right, k-le-1);
        }
        return null;
    }
    public int kthSmallest(TreeNode root, int k) {
        
        TreeNode ans= solve(root, k);
        return ans.val;
    }
}
