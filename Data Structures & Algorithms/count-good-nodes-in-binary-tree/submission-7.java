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

    private int countGood(TreeNode node, int prevMax) {
        if(node == null) {
            return 0;
        }

        int count = countGood(node.left, Math.max(prevMax, node.val)) + 
        countGood(node.right, Math.max(prevMax, node.val));

        if(node.val >= prevMax) {
            count++;
        }

        return count;
    }
}
