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
        ListNode preHead = new ListNode(-1, head), groupPrev = preHead;
        while(true) {
            ListNode kth = getKth(groupPrev, k);
            if(kth==null) {
                return preHead.next;
            }
            ListNode nextGroupPrev = groupPrev.next;
            reverse(groupPrev, kth.next);
            groupPrev = nextGroupPrev;
        }
    }
    private void reverse(ListNode groupPrev, ListNode node) {
        ListNode prev = node, curr = groupPrev.next;
        while(curr!=node) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        groupPrev.next = prev;
    }
    private ListNode getKth(ListNode node, int k) {
        while(k-->0 && node!=null) {
            node = node.next;
        }
        return node;
    }
}
