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
    public Node copyRandomList(Node head) {
        Map<Node, Node> copies = new HashMap<>();
        return copy(head, copies);
    }
    private Node copy(Node node, Map<Node, Node> copies) {
        if(node==null) {
            return null;
        }
        if(copies.containsKey(node)) {
            return copies.get(node);
        }

        Node duplicate = new Node(node.val);
        copies.put(node, duplicate);
        duplicate.next = copy(node.next, copies);
        duplicate.random = copy(node.random, copies);
        return duplicate;
    }
}
