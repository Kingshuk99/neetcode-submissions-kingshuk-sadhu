/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    Map<Node, Node> m;
    public Node copy(Node node) {
        if(node==null) {
            return null;
        }

        if(m.containsKey(node)) {
            return m.get(node);
        }

        Node copyNode = new Node(node.val);
        m.put(node, copyNode);
        copyNode.next = copy(node.next);
        copyNode.random = copy(node.random);
        return copyNode;
    }
    public Node copyRandomList(Node head) {
        m = new HashMap<>();
        return copy(head);
    }
}
