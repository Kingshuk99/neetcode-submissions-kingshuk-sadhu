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

        int interval = 1, n = lists.length;

        while(interval < n) {
            for(int i=0; i<n-interval; i+=2*interval) {
                lists[i] = merge(lists[i], lists[i+interval]);
            }

            interval *= 2;
        }

        return lists[0];
    }

    private ListNode merge(ListNode l1, ListNode l2) {
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
        } else {
            dummy.next = l2;
        }

        return preHead.next;
    }
}
