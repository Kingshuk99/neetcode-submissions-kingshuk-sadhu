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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode preRoot = new ListNode(-101);

        merge(preRoot, list1, list2);
        return preRoot.next;
    }

    private void merge(ListNode preRoot, ListNode list1, ListNode list2) {
        if(list1==null && list2==null) {
            return;
        }

        if(list1==null) {
            preRoot.next = list2;
            return;
        }

        if(list2==null) {
            preRoot.next = list1;
            return;
        }

        if(list1.val<=list2.val) {
            preRoot.next = list1;
            preRoot = preRoot.next;
            list1 = list1.next;
            merge(preRoot, list1, list2);
        }
        else {
            preRoot.next = list2;
            preRoot = preRoot.next;
            list2 = list2.next;
            merge(preRoot, list1, list2);
        }
    }
}