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
    private ListNode head = new ListNode(0);
    private ListNode temp = head;
    public ListNode mergeKLists(ListNode[] lists) {
        merge(lists);
        return head.next;
    }

    private void merge(ListNode[] lists) {
        if(lists.length==0) {
            return;
        }
        ListNode minNode = null;
        int ind = -1;

        for(int i=0; i<lists.length; i++) {
            if(minNode==null && lists[i]!=null) {
                minNode = lists[i];
                ind = i;
            }
            else if(lists[i]!=null && lists[i].val<minNode.val) {
                minNode = lists[i];
                ind = i;
            }
        }

        if(minNode!=null) {
            temp.next = minNode;
            temp = temp.next;
            lists[ind] = lists[ind].next;
            mergeKLists(lists);
        }
    }
}
