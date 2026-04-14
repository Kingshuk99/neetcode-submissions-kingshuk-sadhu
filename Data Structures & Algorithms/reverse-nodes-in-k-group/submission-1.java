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
                break;
            }

            ListNode groupNext = kth.next;
            ListNode prev = kth.next, curr = groupPrev.next;
            while(curr!=groupNext) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            ListNode temp = groupPrev.next;
            groupPrev.next = prev;
            groupPrev = temp;
        }
        return preHead.next;
    }
    private ListNode getKth(ListNode node, int k) {
        while(node!=null && k-->0) {
            node = node.next;
        }
        return node;
    }
}
