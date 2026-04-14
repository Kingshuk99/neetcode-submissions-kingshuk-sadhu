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
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode tail = reverse(slow);

        ListNode front = head;

        while(tail != null && tail.next != null) {
            ListNode frontNext = front.next;
            front.next = tail;
            tail = tail.next;
            front = front.next;
            front.next = frontNext;
            front = front.next;
        }
    }

    private ListNode reverse(ListNode node) {
        ListNode curr = node, prev = null;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
