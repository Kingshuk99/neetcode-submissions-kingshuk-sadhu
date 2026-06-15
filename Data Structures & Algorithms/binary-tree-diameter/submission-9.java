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
    public int diameterOfBinaryTree(TreeNode root) {
        //Recursive DFS
        int[] dia = new int[1];
        dfs(root, dia);
        return dia[0];
    }

    private int dfs(TreeNode node, int[] dia) {
        if(node == null) {
            return 0;
        }

        int left = dfs(node.left, dia), right = dfs(node.right, dia);
        dia[0] = Math.max(dia[0], left + right);

        return Math.max(left, right) + 1;
    }
}
