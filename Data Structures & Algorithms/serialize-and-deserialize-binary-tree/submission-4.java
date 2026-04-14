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
        String[] nodes = data.split(",");
        int[] ind = new int[]{0};
        return deserializeUtil(nodes, ind);
    }
    private TreeNode deserializeUtil(String[] nodes, int[] ind) {
        if(nodes[ind[0]].equals("N")) {
            ind[0]++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(nodes[ind[0]++]));
        root.left = deserializeUtil(nodes, ind);
        root.right = deserializeUtil(nodes, ind);
        return root;
    }
}
