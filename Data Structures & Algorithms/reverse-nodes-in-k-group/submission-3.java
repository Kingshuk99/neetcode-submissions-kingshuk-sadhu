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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1) {
            return head;
        }

        ListNode preHead = new ListNode(-1, head), groupPrev = preHead;
        while(true) {
            ListNode kth = getKth(groupPrev, k);
            if(kth == null) {
                return preHead.next;
            }

            ListNode kthNext = kth.next, tail = groupPrev.next;
            ListNode front = reverse(groupPrev, kthNext);
            groupPrev.next = front;
            tail.next = kthNext;
            groupPrev = tail;
        }
    }

    private ListNode reverse(ListNode prev, ListNode tillBefore) {
        ListNode curr = prev.next;
        while(curr != tillBefore) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private ListNode getKth(ListNode prev, int k) {
        while(prev != null && k-->0) {
            prev = prev.next;
        }
        return prev;
    }
}
