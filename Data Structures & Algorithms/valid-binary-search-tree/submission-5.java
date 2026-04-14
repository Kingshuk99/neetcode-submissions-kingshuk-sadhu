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
        return checkIfValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean checkIfValid(TreeNode node, int left, int right) {
        if(node==null) {
            return true;
        }

        if(node.val <= left || node.val >= right) {
            return false;
        }

        return checkIfValid(node.left, left, Math.min(right, node.val)) && 
        checkIfValid(node.right, Math.max(left, node.val), right);
    }
}
