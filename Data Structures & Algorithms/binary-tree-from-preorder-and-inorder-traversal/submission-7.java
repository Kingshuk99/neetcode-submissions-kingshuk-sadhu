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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //Not Space Optimized
        int[] indexes = new int[2];
        return dfs(preorder, inorder, Integer.MAX_VALUE, indexes);
    }

    private TreeNode dfs(int[] preorder, int[] inorder, int limit, int[] indexes) {
        if(indexes[0] >= preorder.length) {
            return null;
        }

        if(inorder[indexes[1]] == limit) {
            indexes[1]++;
            return null;
        }

        TreeNode root = new TreeNode(preorder[indexes[0]++]);
        root.left = dfs(preorder, inorder, root.val, indexes);
        root.right = dfs(preorder, inorder, limit, indexes);

        return root;
    }
}
