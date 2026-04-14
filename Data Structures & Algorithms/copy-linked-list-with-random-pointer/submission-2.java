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

        Node original = head;
        while(original != null) {
            Node duplicate = new Node(original.val);
            duplicate.next = original.next;
            original.next = duplicate;
            original = original.next.next;
        }

        original = head;
        Node newHead = head.next;

        while(original != null) {
            if(original.random != null) {
                original.next.random = original.random.next;
            }
            original = original.next.next;
        }

        original = head;
        while(original != null) {
            Node duplicate = original.next;
            original.next = duplicate.next;
            if(duplicate.next != null) {
                duplicate.next = original.next.next;
            }
            original = original.next;
        }

        return newHead;
    }
}
