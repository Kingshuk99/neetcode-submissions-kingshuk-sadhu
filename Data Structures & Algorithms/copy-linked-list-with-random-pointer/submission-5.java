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
        Node dummy = head;
        while(dummy != null) {
            Node temp = dummy.next;
            dummy.next = new Node(dummy.val);
            dummy.next.next = temp;
            dummy = dummy.next.next;
        }

        Node copyHead = head.next;

        dummy = head;
        while(dummy != null) {
            if(dummy.random != null) {
                dummy.next.random = dummy.random.next;
            }
            dummy = dummy.next.next;
        }

        dummy = head;
        while(dummy != null) {
            Node temp = dummy.next;
            dummy.next = temp.next;
            if(dummy.next != null) {
                temp.next = dummy.next.next;
            }
            dummy = dummy.next;
        }

        return copyHead;
    }
}
