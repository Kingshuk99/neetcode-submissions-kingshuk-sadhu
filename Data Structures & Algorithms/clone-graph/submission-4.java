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
        if(node == null) {
            return null;
        }
        Map<Node, Node> clones = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        clones.put(node, new Node(node.val));

        while(!queue.isEmpty()) {
            Node curr = queue.poll();
            if(curr.neighbors == null || curr.neighbors.size() < 1) {
                continue;
            }
            List<Node> clonedNeighbors = new ArrayList<>();
            for(Node neighbor : curr.neighbors) {
                if(clones.containsKey(neighbor)) {
                    clonedNeighbors.add(clones.get(neighbor));
                    continue;
                }
                Node clonedNeighbor = new Node(neighbor.val);
                queue.offer(neighbor);
                clones.put(neighbor, clonedNeighbor);
                clonedNeighbors.add(clonedNeighbor);
            }
            clones.get(curr).neighbors = clonedNeighbors;
        }
        return clones.get(node);
    }
}