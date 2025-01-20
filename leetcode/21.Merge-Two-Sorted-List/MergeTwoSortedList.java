/**
 * Created: 2025-01-20
 * Author: UoRoot
 */
public class MergeTwoSortedList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }

        ListNode temp = new ListNode(
                Math.min(list1.val, list2.val));
        ListNode head = temp;

        helper(temp,
                getLowestNode(list1, list2).next,
                getHigherNode(list1, list2));

        return head;
    }

    private void helper(ListNode head, ListNode a, ListNode b) {
        if (a == null || b == null) {
            head.next = a == null ? b : a;
            return;
        }

        head.next = new ListNode(getLowestNode(a, b).val);
        head = head.next;
        
        helper(head, getLowestNode(a, b).next, getHigherNode(a, b));
    }

    private ListNode getLowestNode(ListNode a, ListNode b) {
        return a.val < b.val ? a : b;
    }

    private ListNode getHigherNode(ListNode a, ListNode b) {
        return a.val < b.val ? b : a;
    }

}