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
        ListNode dummy = new ListNode(-1, head), tail = dummy, back = dummy;

        while(tail != null && n-- > 0) {
            tail = tail.next;
        }

        if(tail == null) {
            return head;
        }

        while(tail.next != null) {
            back = back.next;
            tail = tail.next;
        }

        back.next = back.next.next;

        return dummy.next;
    }
}
