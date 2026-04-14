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
    Map<Node, Node> copies = new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head == null) {
            return null;
        }

        if(copies.containsKey(head)) {
            return copies.get(head);
        }

        Node copy = new Node(head.val);
        copies.put(head, copy);
        copy.next = copyRandomList(head.next);
        copy.random = copyRandomList(head.random);

        return copy;
    }
}
