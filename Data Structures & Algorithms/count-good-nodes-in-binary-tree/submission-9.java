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
        //BFS
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        int count = 0;

        queue.offer(new Pair<>(root, Integer.MIN_VALUE));

        while(!queue.isEmpty()) {
            Pair<TreeNode, Integer> curr = queue.poll();
            TreeNode node = curr.getKey();
            int prevMax = curr.getValue();

            if(node == null) {
                continue;
            }

            if(node.val >= prevMax) {
                count++;
            }

            queue.offer(new Pair<>(node.left, Math.max(node.val, prevMax)));
            queue.offer(new Pair<>(node.right, Math.max(node.val, prevMax)));
        }

        return count;
    }
}
