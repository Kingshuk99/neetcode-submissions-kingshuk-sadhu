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
        int[] indices = new int[]{0, 0}; // pre and in respectively
        int LIMIT = Integer.MAX_VALUE;
        return dfs(preorder, inorder, indices, LIMIT);
    }

    private TreeNode dfs(int[] preorder, int[] inorder, int[] indices, 
    int limit) {
        if(indices[0]==preorder.length) {
            return null;
        }

        if(inorder[indices[1]]==limit) {
            indices[1]++;
            return null;
        }

        TreeNode root = new TreeNode(preorder[indices[0]++]);
        root.left = dfs(preorder, inorder, indices, root.val);
        root.right = dfs(preorder, inorder, indices, limit);

        return root;
    }
}
