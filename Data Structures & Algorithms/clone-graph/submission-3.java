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
        Map<Node, Node> clones = new HashMap<>();
        return dfs(node, clones);
    }

    private Node dfs(Node node, Map<Node, Node> clones) {
        if(node == null) {
            return null;
        }
        if(clones.containsKey(node)) {
            return clones.get(node);
        }

        Node cloned = new Node(node.val);
        clones.put(node, cloned);
        if(node.neighbors == null || node.neighbors.size() < 1) {
            return cloned;
        }
        List<Node> clonedNeighbors = new ArrayList<>();
        for(Node neighbor : node.neighbors) {
            clonedNeighbors.add(dfs(neighbor, clones));
        }
        cloned.neighbors = clonedNeighbors;
        return cloned;
    }
}