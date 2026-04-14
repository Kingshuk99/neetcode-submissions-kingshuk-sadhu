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
        return countGood(root, root.val);
    }

    private int countGood(TreeNode root, int prev) {
        if(root==null) {
            return 0;
        }

        int count = countGood(root.left, Math.max(prev, root.val)) + 
        countGood(root.right, Math.max(prev, root.val));

        if(root.val >= prev) {
            count++;
        }

        return count;
    }
}
