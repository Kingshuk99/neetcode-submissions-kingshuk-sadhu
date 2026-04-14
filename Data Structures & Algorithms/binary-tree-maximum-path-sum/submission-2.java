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
    public int maxPathSum(TreeNode root) {
        int[] ans = new int[]{root.val};
        dfs(root, ans);
        return ans[0];
    }

    private int dfs(TreeNode root, int[] ans) {
        if(root==null) {
            return 0;
        }

        int lmax = Math.max(dfs(root.left, ans), 0);
        int rmax = Math.max(dfs(root.right, ans), 0);

        ans[0] = Math.max(ans[0], lmax+root.val+rmax);

        return root.val+Math.max(lmax, rmax);
    }
}
