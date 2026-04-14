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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        return add(l1, l2, carry);
    }
    private ListNode add(ListNode l1, ListNode l2, int carry) {
        if(l1==null && l2==null && carry==0) {
            return null;
        }
        int l1Val = l1 != null ? l1.val : 0;
        int l2Val = l2 != null ? l2.val : 0;

        l1 = l1 != null ? l1.next : null;
        l2 = l2 != null ? l2.next : null;

        int tot = l1Val+l2Val+carry;

        ListNode node = new ListNode(tot%10);

        node.next = add(l1, l2, tot/10);

        return node;
    }
}
