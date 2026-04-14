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
        calculateMaxSum(root, ans);
        return ans[0];
    }

    private int calculateMaxSum(TreeNode root, int[] ans) {
        if(root==null) {
            return 0;
        }

        int left = Math.max(calculateMaxSum(root.left, ans), 0);
        int right = Math.max(calculateMaxSum(root.right, ans), 0);

        ans[0] = Math.max(ans[0], left+right+root.val);

        return Math.max(left, right) + root.val;
    }
}
