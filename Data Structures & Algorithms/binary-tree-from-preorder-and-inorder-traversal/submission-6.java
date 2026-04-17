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
        TreeNode preRoot = new TreeNode(0);
        TreeNode curr = preRoot;
        int i = 0, j = 0, n = preorder.length;

        while(i < n && j < n) {
            TreeNode temp = new TreeNode(preorder[i++]);
            temp.right = curr.right;
            curr.right = temp;
            curr = curr.right;

            while(i < n && curr.val != inorder[j]) {
                curr.left = new TreeNode(preorder[i++]);
                curr.left.right = curr;
                curr = curr.left;
            }

            j++;

            while(curr.right != null && j < n && curr.right.val == inorder[j]) {
                TreeNode prev = curr.right;
                curr.right = null;
                curr = prev;
                j++;
            }
        }
        return preRoot.right;
    }
}
