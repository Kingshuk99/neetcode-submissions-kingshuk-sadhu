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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }

        return divide(lists, 0, lists.length - 1);
    }

    private ListNode divide(ListNode[] lists, int l, int r) {
        if(l > r) {
            return null;
        }

        if(l == r) {
            return lists[l];
        }

        int mid = l + (r - l)/2;

        ListNode left = divide(lists, l, mid);
        ListNode right = divide(lists, mid + 1, r);

        return conquer(left, right);
    }

    private ListNode conquer(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1001), dummy = preHead;

        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                dummy.next = l1;
                l1 = l1.next;
            } else {
                dummy.next = l2;
                l2 = l2.next;
            }
            dummy = dummy.next;
        }

        if(l1 != null) {
            dummy.next = l1;
        }

        if(l2 != null) {
            dummy.next = l2;
        }

        return preHead.next;
    }
}
