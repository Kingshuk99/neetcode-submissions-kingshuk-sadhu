/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Map<Node, Node> dp = new HashMap<>();
        return dfs(node, dp);
    }

    private Node dfs(Node node, Map<Node, Node> dp) {
        if(node == null) {
            return null;
        }

        if(dp.containsKey(node)) {
            return dp.get(node);
        }

        Node newNode = new Node(node.val);
        dp.put(node, newNode);

        List<Node> neighs = new ArrayList<>();
        for(Node curr : node.neighbors) {
            newNode.neighbors.add(dfs(curr, dp));
        }

        return newNode;
    }
}