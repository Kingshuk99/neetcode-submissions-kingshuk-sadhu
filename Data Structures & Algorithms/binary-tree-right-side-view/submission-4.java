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
        //DFS
        List<Integer> rightView = new ArrayList<>();
        dfs(root, 0, rightView);
        return rightView;
    }

    private void dfs(TreeNode node, int depth, List<Integer> rightView) {
        if(node == null) {
            return;
        }

        if(rightView.size() == depth) {
            rightView.add(node.val);
        }

        dfs(node.right, depth + 1, rightView);
        dfs(node.left, depth + 1, rightView);
    }
}
