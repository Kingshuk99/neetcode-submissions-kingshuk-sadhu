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
        String rootEncoded = serialize(root), subRootEncoded = serialize(subRoot);

        String encoded = subRootEncoded + "|" + rootEncoded;

        int[] zArray = computeZArray(encoded);
        int subRootLen = subRootEncoded.length();

        for(int i = subRootLen+1; i < encoded.length(); i++) {
            if(zArray[i] == subRootLen) {
                return true;
            }
        }

        return false;
    }

    private String serialize(TreeNode root) {
        if(root == null) {
            return "$#";
        }

        return "$" + root.val + serialize(root.left) + serialize(root.right);
    }

    private int[] computeZArray(String s) {
        int l = 0, r = 0, n = s.length();
        int[] z = new int[n];

        for(int i=1; i<n; i++) {
            if(i <= r) {
                z[i] = Math.min(r-i+1, z[i-l]);
            }

            while(i+z[i]<n && s.charAt(z[i]) == s.charAt(i+z[i])) {
                z[i]++;
            }
            if(i+z[i]-1 > r) {
                l = i;
                r = i+z[i]-1;
            }
        }
        return z;
    }
}
