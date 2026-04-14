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
        ListNode temp = head, temp2 = head.next;
        if(temp==null || temp.next==null || temp.next.next==null) {
            return;
        }
        while(temp.next.next!=null) {
            temp = temp.next;
        }
        head.next = temp.next;
        temp.next = null;
        head.next.next = temp2;
        reorderList(head.next.next);
    }
}
