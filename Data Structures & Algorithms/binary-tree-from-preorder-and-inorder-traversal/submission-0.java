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
        if(preorder.length==0 || inorder.length==0) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);

        int ind = -1;
        for(int i=0; i<inorder.length; i++) {
            if(inorder[i]==preorder[0]) {
                ind = i;
                break;
            }
        }

        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, ind+1);
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, ind);

        root.left = buildTree(leftPreorder, leftInorder);

        int[] rightPreorder = Arrays.copyOfRange(preorder, ind+1, preorder.length);
        int[] rightInorder = Arrays.copyOfRange(inorder, ind+1, inorder.length);

        root.right = buildTree(rightPreorder, rightInorder);

        return root;
    }
}
