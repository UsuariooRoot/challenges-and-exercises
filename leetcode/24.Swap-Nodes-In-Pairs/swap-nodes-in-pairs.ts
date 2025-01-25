/**
 * Created: 2025-01-25
 * Author: UoRoot
 * Problem: https://leetcode.com/problems/swap-nodes-in-pairs
 */
class ListNode {
    val: number
    next: ListNode | null
    constructor(val?: number, next?: ListNode | null) {
        this.val = (val === undefined ? 0 : val)
        this.next = (next === undefined ? null : next)
    }
}

function swapPairs(head: ListNode | null): ListNode | null {
    if (head === null || head.next === null) return head;

    let dummy = new ListNode(0);
    let active = true;
    const res = dummy;

    while (head !== null && head.next !== null) {
        dummy.next = new ListNode(active ? head.next.val : head.val);
        if (!active)
            head = head.next.next;
        dummy = dummy.next;
        active = !active;
    }

    if (head != null) {
        dummy.next = new ListNode(head.val);
    }

    return res.next;
};

function swapPairs2(head: ListNode | null): ListNode | null {
    if (head === null || head.next === null) return head;

    const dummy = new ListNode(0, head);
    let temp = dummy;

    while (temp.next && temp.next.next) {
        let first = temp.next;
        let second = temp.next.next;

        first.next = second.next;
        second.next = first;
        temp.next = second;
        temp = first;
    }

    return dummy.next;
};