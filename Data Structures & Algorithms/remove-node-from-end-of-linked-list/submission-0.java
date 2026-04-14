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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ans = new ListNode(0, head);
        ListNode tempHead = ans, tempTail = head;
        while(n>0) {
            tempTail = tempTail.next;
            n--;
        }

        while(tempTail!=null) {
            tempHead = tempHead.next;
            tempTail = tempTail.next;
        }
        tempHead.next = tempHead.next.next;
        return ans.next;
    }
}
