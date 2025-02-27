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
    //easy peasy.
    //
    List<List<Integer>>ans= new ArrayList<>();
    public void solve(TreeNode root, int targetSum, int sum, List<Integer>l)
    {
        if(root!=null && root.left==null && root.right==null)
        {
            sum+= root.val;
            l.add(root.val);
            if(sum==targetSum)
            {
                ans.add(new ArrayList<>(l));
            }
            l.remove(l.size()-1);
            return ;
        }
        if(root==null)
        {
            return;
        }

        sum+=root.val;
        l.add(root.val);
        
            solve(root.left, targetSum,sum, l);

            solve(root.right, targetSum,sum, l);
        
        l.remove(l.size()-1);
        

    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer>l= new ArrayList<>();
        solve(root, targetSum, 0, l);
        return ans;
    }
}
