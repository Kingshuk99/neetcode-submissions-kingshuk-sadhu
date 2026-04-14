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
        ListNode preHead = new ListNode(-1001);
        merge(preHead, lists);
        return preHead.next;
    }

    private void merge(ListNode preNode, ListNode[] lists) {
        int index = getMinNode(lists);
        if(index==-1) {
            return;
        }

        preNode.next = lists[index];
        lists[index] = lists[index].next;
        merge(preNode.next, lists);
    }

    private int getMinNode(ListNode[] lists) {
        int index = -1;

        for(int i=0; i<lists.length; i++) {
            ListNode list = lists[i];
            if(list==null) {
                continue;
            }
            if(index==-1) {
                index = i;
            }
            else {
                if(lists[index].val>list.val) {
                    index = i;
                }
            }
        }
        return index;
    }
}
