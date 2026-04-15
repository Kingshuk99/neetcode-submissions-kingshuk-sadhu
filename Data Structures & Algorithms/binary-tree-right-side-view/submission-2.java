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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightView = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            TreeNode rightSide = null;
            int n = queue.size();

            for(int i=0; i<n; i++) {
                TreeNode node = queue.poll();
                if(node != null) {
                    rightSide = node;
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }

            if(rightSide != null) {
                rightView.add(rightSide.val);
            }
        }

        return rightView;
    }
}
