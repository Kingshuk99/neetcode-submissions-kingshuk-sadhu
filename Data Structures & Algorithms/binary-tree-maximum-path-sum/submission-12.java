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
        if(root == null) {
            return 0;
        }
        int[] pathSum = new int[]{root.val};
        dfs(root, pathSum);
        return pathSum[0];
    }

    private int dfs(TreeNode node, int[] pathSum) {
        if(node == null) {
            return 0;
        }

        int left = Math.max(dfs(node.left, pathSum), 0);
        int right = Math.max(dfs(node.right, pathSum), 0);

        pathSum[0] = Math.max(pathSum[0], left + node.val + right);
        return Math.max(left, right) + node.val;
    }
}
