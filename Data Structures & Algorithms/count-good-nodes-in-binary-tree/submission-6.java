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
        // BFS
        // int res = 0;
        // Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        // q.offer(new Pair<>(root, Integer.MIN_VALUE));

        // while (!q.isEmpty()) {
        //     Pair<TreeNode, Integer> pair = q.poll();
        //     TreeNode node = pair.getKey();
        //     int maxval = pair.getValue();
        //     if (node.val >= maxval) {
        //         res++;
        //     }
        //     if (node.left != null) {
        //         q.offer(new Pair<>(node.left, Math.max(maxval, node.val)));
        //     }
        //     if (node.right != null) {
        //         q.offer(new Pair<>(node.right, Math.max(maxval, node.val)));
        //     }
        // }
        // return res;

        // DFS
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
