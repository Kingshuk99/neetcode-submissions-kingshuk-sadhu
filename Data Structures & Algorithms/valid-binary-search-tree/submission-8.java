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
        //BFS
        Queue<Object[]> queue = new LinkedList<>();
        queue.offer(new Object[]{root, Integer.MIN_VALUE, Integer.MAX_VALUE});

        while(!queue.isEmpty()) {
            Object[] curr = queue.poll();
            TreeNode node = (TreeNode) curr[0];
            int left = (int) curr[1], right = (int) curr[2];

            if(node == null) {
                continue;
            }

            if(node.val <= left || node.val >= right) {
                return false;
            }

            queue.offer(new Object[]{node.left, left, node.val});
            queue.offer(new Object[]{node.right, node.val, right});
        }

        return true;
    }
}
