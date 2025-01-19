public class MiddleOfTheLinkedList {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    
    public ListNode middleNode(ListNode head) {
        if (head == null) return head;
        int length = 1;
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
            length++;
        }

        int pointer = (length / 2) + 1;
        for (int i = 1; i < pointer; i++) {
            head = head.next;
        }

        return head;
    }
    
    // Two node lists, one advances twice as fast as the other
    public ListNode middleNode2(ListNode head) {
        ListNode normal = head;
        ListNode advanced = head;

        while(advanced != null && advanced.next != null) {
            normal = normal.next;
            advanced = advanced.next.next;
        }

        return normal;
    }
}