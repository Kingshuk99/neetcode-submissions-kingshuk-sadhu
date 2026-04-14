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
    public boolean isValidBST(TreeNode root) {
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean checkBST(TreeNode root, int left, int right) {
        if(root==null) {
            return true;
        }

        if(root.val<=left || root.val>=right) {
            return false;
        }

        return checkBST(root.left, left, Math.min(right, root.val)) &&
        checkBST(root.right, Math.max(left, root.val), right);
    }
}
