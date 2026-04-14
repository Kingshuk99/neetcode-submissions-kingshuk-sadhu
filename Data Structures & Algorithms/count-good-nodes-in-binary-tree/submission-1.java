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
        return countGoodNodes(root, root.val, 0);
    }

    private int countGoodNodes(TreeNode root, int maxVal, int count) {
        if(root==null) {
            return count;
        }
        
        int left = countGoodNodes(root.left, Math.max(maxVal, root.val), count);
        int right = countGoodNodes(root.right, Math.max(maxVal, root.val), count);

        if(root.val>=maxVal) {
            count++;
        }

        count += (left+right);

        return count;
    }
}
