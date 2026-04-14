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
        solve(root, ans);
        return ans[0];
    }

    private int solve(TreeNode node, int[] ans) {
        if(node==null) {
            return 0;
        }

        int left = Math.max(0, solve(node.left, ans));
        int right = Math.max(0, solve(node.right, ans));

        ans[0] = Math.max(ans[0], left+right+node.val);

        return Math.max(left, right) + node.val;
    }
}
