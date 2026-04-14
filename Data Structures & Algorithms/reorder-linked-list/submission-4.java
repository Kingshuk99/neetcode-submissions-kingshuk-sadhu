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
        if(head==null || head.next==null || head.next.next==null) {
            return;
        }
        ListNode slow = head, fast = head;
        while(fast.next!=null) {
            slow = slow.next;
            fast = fast.next;
            if(fast.next!=null) {
                fast = fast.next;
            }
        }

        ListNode tail = reverse(slow);
        ListNode front = head;
        while(tail != null && tail.next!=null) {
            ListNode temp = front.next;
            front.next = tail;
            tail = tail.next;
            front = front.next;
            front.next = temp;
            front = front.next;
        }
    }

    private ListNode reverse(ListNode prev) {
        ListNode curr = prev.next, next = null;
        prev.next = null;

        while(curr!=null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
