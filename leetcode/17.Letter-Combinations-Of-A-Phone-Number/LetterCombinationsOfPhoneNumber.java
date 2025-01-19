import java.util.ArrayList;
import java.util.List;

/**
 * Created: 2025-01-18
 * Author: UoRoot
 */
public class LetterCombinationsOfPhoneNumber {

    public static List<String> letterCombinations(String digits) {
        if (digits.isEmpty())
            return List.of();

        Node head = createDoublyLinkedList(digits);
        Node temp = head;

        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        while (temp != null) {
            if (temp.lastIdx >= temp.val.length) {
                temp.lastIdx = 0;
                temp = temp.prev;
                if (sb.length() - 1 >= 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else if (temp.next == null) {
                while (temp.lastIdx < temp.val.length) {
                    res.add(sb.toString() + temp.val[temp.lastIdx++]);
                }
                temp.lastIdx = 0;
                temp = temp.prev;
                if (sb.length() - 1 >= 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else {
                sb.append(temp.val[temp.lastIdx++]);
                temp = temp.next;
            }
        }

        return res;
    }

    public static List<String> letterCombinations2(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.isEmpty())
            return res;

        backtrack(digits, res, new StringBuilder());
        return res;
    }

    private static void backtrack(String digits, List<String> res, StringBuilder com) {
        if (digits.isEmpty()) {
            res.add(com.toString());
            return;
        }

        char[] letters = keyboard[digits.charAt(0) - 48];

        for (int i = 0; i < letters.length; i++) {
            backtrack(digits.substring(1), res, com.append(letters[i]));
            com.deleteCharAt(com.length() - 1);
        }
    }

    static class Node {
        char[] val;
        int lastIdx;
        Node prev;
        Node next;

        public Node(char[] val) {
            this.val = val;
        }

        public Node(char[] val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

    private final static char[][] keyboard = new char[][] {
            {},
            {},
            { 'a', 'b', 'c' },
            { 'd', 'e', 'f' },
            { 'g', 'h', 'i' },
            { 'j', 'k', 'l' },
            { 'm', 'n', 'o' },
            { 'p', 'q', 'r', 's' },
            { 't', 'u', 'v' },
            { 'w', 'x', 'y', 'z' }
    };

    private static Node createDoublyLinkedList(String digits) {

        Node head = new Node(keyboard[digits.charAt(0) - 48]);
        Node current = head;

        for (int i = 1; i < digits.length(); i++) {
            Node newNode = new Node(keyboard[digits.charAt(i) - 48]);
            newNode.prev = current;
            current.next = newNode;
            current = newNode;
        }

        return head;
    }

}
