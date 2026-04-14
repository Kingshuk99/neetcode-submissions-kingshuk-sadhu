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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-101);
        merge(head, list1, list2);
        return head.next;
    }
    private void merge(ListNode head, ListNode l1, ListNode l2) {
        if(l1==null && l2==null) {
            return;
        }
        if(l1==null) {
            head.next = l2;
            return;
        }
        if(l2==null) {
            head.next = l1;
            return;
        }

        if(l1.val<=l2.val) {
            head.next = l1;
            l1 = l1.next;
        } else {
            head.next = l2;
            l2 = l2.next;
        }
        merge(head.next, l1, l2);
    }
}