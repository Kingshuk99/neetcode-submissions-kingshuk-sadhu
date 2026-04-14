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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> res = new ArrayList<>();
        serializeUtil(root, res);
        return String.join(",", res);
    }

    private void serializeUtil(TreeNode node, List<String> res) {
        if(node==null) {
            res.add("N");
            return;
        }

        res.add(String.valueOf(node.val));
        serializeUtil(node.left, res);
        serializeUtil(node.right, res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] res = data.split(",");
        int[] i = new int[]{0};
        return deserializeUtil(res, i);
    }

    private TreeNode deserializeUtil(String[] res, int[] i) {
        if(res[i[0]].equals("N")) {
            i[0]++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(res[i[0]++]));
        node.left = deserializeUtil(res, i);
        node.right = deserializeUtil(res, i);

        return node;
    }
}
