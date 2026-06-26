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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //Space Optimized (Morris Traversal)
        TreeNode preRoot = new TreeNode(0);
        TreeNode curr = preRoot;

        int preInd = 0, inInd = 0, n = preorder.length;

        while(preInd < n && inInd < n) {
            curr.right = new TreeNode(preorder[preInd], null, curr.right);
            curr = curr.right;
            preInd++;

            while(preInd < n && curr.val != inorder[inInd]) {
                curr.left = new TreeNode(preorder[preInd], null, curr);
                curr = curr.left;
                preInd++;
            }
            inInd++;
            while(curr.right != null && inInd < n && 
            curr.right.val == inorder[inInd]) {
                TreeNode parent = curr.right;
                curr.right = null;
                curr = parent;
                inInd++;
            }
        }

        return preRoot.right;
    }
}
