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
        if(root==null) {
            return 0;
        }
        return countGoodNodes(root, root.val);
    }

    private int countGoodNodes(TreeNode node, int prevMax) {
        if(node==null) {
            return 0;
        }

        int count = countGoodNodes(node.left, Math.max(prevMax, node.val)) +
        countGoodNodes(node.right, Math.max(prevMax, node.val));

        if(node.val>=prevMax) {
            count++;
        }

        return count;
    }
}
