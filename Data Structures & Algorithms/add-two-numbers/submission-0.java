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
    private int carry = 0;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return add(l1, l2);
    }

    private ListNode add(ListNode l1, ListNode l2) {
        int sum = carry;
        if(l1 != null) {
            sum += l1.val;
            l1 = l1.next;
        }
        if(l2 != null) {
            sum += l2.val;
            l2 = l2.next;
        }

        carry = sum/10;
        sum = sum%10;

        ListNode node = new ListNode(sum);
        if(l1!=null || l2!=null || carry!=0) {
            node.next = add(l1, l2);
        }

        return node;
    }
}
