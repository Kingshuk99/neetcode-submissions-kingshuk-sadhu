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
        if(head == null) {
            return;
        }
        ListNode slow = head, fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode tail = reverse(slow);
        ListNode temp = head;

        while(temp != null && tail.next != null) {
            ListNode tempNext = temp.next;
            temp.next = tail;
            tail = tail.next;
            temp.next.next = tempNext;
            temp = tempNext;
        }
    }

    private ListNode reverse(ListNode node) {
        ListNode prev = null;
        while(node != null) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }
}
