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
        String rootEncoded = encode(root), subrootEncoded = encode(subRoot);

        int subrootLen = subrootEncoded.length();

        String combinedString = subrootEncoded + "|" + rootEncoded;

        int[] zArr = computeZArr(combinedString);

        for(int i = subrootLen + 1; i < combinedString.length(); i++) {
            if(zArr[i] == subrootLen) {
                return true;
            }
        }

        return false;
    }

    private int[] computeZArr(String str) {
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

    private String encode(TreeNode node) {
        if(node == null) {
            return "$#";
        }

        return "$" + node.val + encode(node.left) + encode(node.right);
    }
}
