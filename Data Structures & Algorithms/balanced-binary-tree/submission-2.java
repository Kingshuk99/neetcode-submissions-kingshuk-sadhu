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
    public boolean isBalanced(TreeNode root) {
        return dfs(root)[0] == 1;
    }

    private int[] dfs(TreeNode node) {
        if(node == null) {
            return new int[]{1, 0};
        }

        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        int leftHeight = left[1], rightHeight = right[1];
        int height = Math.max(leftHeight, rightHeight) + 1;

        if(left[0] != 1 || right[0] != 1 || Math.abs(leftHeight - rightHeight) > 1) {
            return new int[] {0, height};
        }

        return new int[] {1, height};
    }
}
