/**
 * Created: 2025-01-17
 * Author: UoRoot
 */
public class RemoveNthNodeFromEndOfList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null)
            return null;

        if (n == 1) {
            ListNode temp = new ListNode(head.val);
            ListNode res = temp;
            while (head.next.next != null) {
                temp.next = new ListNode(head.next.val);
                head = head.next;
                temp = temp.next;
            }
            return res;
        }

        ListNode afterNth = head;
        for (int i = 1; i < n && afterNth.next != null; i++) {
            afterNth = afterNth.next;
        }

        if (afterNth.next == null) {
            return head.next;
        }

        ListNode left = head;
        ListNode temp = new ListNode(head.val);
        ListNode res = temp;

        afterNth = afterNth.next;
        while (afterNth.next != null) {
            afterNth = afterNth.next;
            left = left.next;
            temp.next = new ListNode(left.val);
            temp = temp.next;
        }

        temp.next = left.next.next;
        return res;
    }

    static void prinListNode(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.print("\n");
    }
}