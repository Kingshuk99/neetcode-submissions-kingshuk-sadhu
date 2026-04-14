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
    int ans = 0;
    public int maxPathSum(TreeNode root) {
        ans = root.val;
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        if(root==null) {
            return 0;
        }

        int leftMax = Math.max(dfs(root.left), 0);
        int rightMax = Math.max(dfs(root.right), 0);

        ans = Math.max(ans, leftMax + root.val + rightMax);

        return root.val + Math.max(leftMax, rightMax);
    }
}
