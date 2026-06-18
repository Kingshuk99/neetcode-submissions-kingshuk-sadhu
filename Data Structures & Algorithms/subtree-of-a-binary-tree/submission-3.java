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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        String subTreeEncoded = encode(subRoot), treeEncoded = encode(root);
        int subTreeLen = subTreeEncoded.length();
        String encoded = subTreeEncoded + "|" + treeEncoded;

        int[] zArr = computeZ(encoded);

        for(int len : zArr) {
            if(len == subTreeLen) {
                return true;
            }
        }

        return false;
    }

    private String encode(TreeNode node) {
        if(node == null) {
            return "$#";
        }

        return "$" + node.val + encode(node.left) + encode(node.right);
    }

    private int[] computeZ(String str) {
        int l = 0, r = 0, n = str.length();

        int[] z = new int[n];
        for(int i = 1; i < n; i++) {
            if(i <= r) {
                z[i] = Math.min(r - i + 1, z[i - l]);
            }

            while(i + z[i] < n && str.charAt(z[i]) == str.charAt(z[i] + i)) {
                z[i]++;
            }

            if(i + z[i] - 1 > r) {
                l = i;
                r = i + z[i] - 1;
            }
        }

        return z;
    }
}
