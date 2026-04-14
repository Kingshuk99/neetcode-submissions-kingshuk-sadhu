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
    public int goodNodes(TreeNode root) {
        return dfs(root, -100);
    }
    private int dfs(TreeNode node, int currMax) {
        if(node==null) {
            return 0;
        }

        int res = 0;

        if(node.val >= currMax) {
            res++;
            currMax = node.val;
        }
        
        res += dfs(node.left, currMax);
        res += dfs(node.right, currMax);

        return res;
    }
}
