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
    public List<List<Integer>> levelOrder(TreeNode root) {
        //BFS
        if(root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        List<List<Integer>> ans = new ArrayList<>();
        
        while(!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> res = new ArrayList<>();
            for(int i=0; i<n; i++) {
                TreeNode node = queue.poll();
                res.add(node.val);
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            ans.add(res);
        }
        return ans;
    }
}
