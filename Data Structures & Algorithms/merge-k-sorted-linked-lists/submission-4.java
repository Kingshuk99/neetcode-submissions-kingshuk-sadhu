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
        int n = lists.length;
        if(n == 0) {
            return null;
        }

        int interval = 1;
        while(interval < n) {
            for(int i=0; i<n-interval; i+=2*interval) {
                lists[i] = merge(lists[i], lists[i+interval]);
            }
            interval *= 2;
        }

        return lists[0];
    }

    private ListNode merge(ListNode node1, ListNode node2) {
        ListNode preHead = new ListNode(-1001);
        ListNode dummy = preHead;

        while(node1 != null && node2 != null) {
            if(node1.val <= node2.val) {
                dummy.next = node1;
                node1 = node1.next;
            } else {
                dummy.next = node2;
                node2 = node2.next;
            }
            dummy = dummy.next;
        }

        if(node1 != null) {
            dummy.next = node1;
        }

        if(node2 != null) {
            dummy.next = node2;
        }

        return preHead.next;
    }
}
