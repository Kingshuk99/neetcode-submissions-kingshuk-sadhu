/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode front = new ListNode(-1, head), tail = head, dummy = front;
        while(n-->0) {
            tail = tail.next;
        }

        while(tail!=null) {
            tail = tail.next;
            front = front.next;
        }

        front.next = front.next.next;
        return dummy.next;
    }
}
