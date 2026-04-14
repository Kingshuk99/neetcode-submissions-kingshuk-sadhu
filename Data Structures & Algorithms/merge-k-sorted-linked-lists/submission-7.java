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
        if(lists == null || lists.length == 0) {
            return null;
        }

        return divide(lists, 0, lists.length-1);
    }

    private ListNode divide(ListNode[] lists, int l, int r) {
        if(l > r) {
            return null;
        }

        if(l == r) {
            return lists[l];
        }

        int mid = l + (r-l)/2;
        ListNode left = divide(lists, l, mid);
        ListNode right = divide(lists, mid+1, r);

        return conquer(left, right);
    }

    private ListNode conquer(ListNode left, ListNode right) {
        ListNode preHead = new ListNode(-1001), dummy = preHead;

        while(left != null && right != null) {
            if(left.val <= right.val) {
                dummy.next = left;
                left = left.next;
            } else {
                dummy.next = right;
                right = right.next;
            }
            dummy = dummy.next;
        }

        if(left != null) {
            dummy.next = left;
        } else {
            dummy.next = right;
        }

        return preHead.next;
    }
}
