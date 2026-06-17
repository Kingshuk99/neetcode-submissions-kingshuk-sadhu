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
    public int diameterOfBinaryTree(TreeNode root) {
        //Iterative DFS
        Map<TreeNode, int[]> nodeData = new HashMap<>();
        nodeData.put(null, new int[]{0, 0});

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while(!stack.isEmpty()) {
            TreeNode node = stack.peek();

            if(node.left != null && !nodeData.containsKey(node.left)) {
                stack.push(node.left);
                continue;
            }

            if(node.right != null && !nodeData.containsKey(node.right)) {
                stack.push(node.right);
                continue;
            }

            node = stack.pop();
            int[] leftData = nodeData.get(node.left);
            int[] rightData = nodeData.get(node.right);

            int leftHeight = leftData[0], leftDia = leftData[1];
            int rightHeight = rightData[0], rightDia = rightData[1];

            int height = Math.max(leftHeight, rightHeight) + 1;
            int dia = Math.max(Math.max(leftDia, rightDia), 
            leftHeight + rightHeight);

            nodeData.put(node, new int[]{height, dia});
        }

        return nodeData.get(root)[1];
    }
}
