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
        if(head == null) {
            return null;
        }

        Node org = head;

        while(org != null) {
            Node rand = org.random;
            Node dup = new Node(org.val);
            org.random = dup;
            dup.next = rand;
            org = org.next;
        }

        Node newHead = head.random;

        org = head;

        while(org != null) {
            Node dup = org.random;
            dup.random = dup.next != null ? dup.next.random : null;
            org = org.next;
        }

        org = head;

        while(org != null) {
            Node dup = org.random;
            org.random = dup.next;
            dup.next = org.next != null ? org.next.random : null;
            org = org.next;
        }

        return newHead;
    }
}
