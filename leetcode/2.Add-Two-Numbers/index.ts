class ListNode {
  val: number;
  next: ListNode | null;
  constructor(val?: number, next?: ListNode | null) {
      this.val = val === undefined ? 0 : val;
      this.next = next === undefined ? null : next;
  }
}

function addTwoNumbers(l1: ListNode | null, l2: ListNode | null): ListNode | null {
  let listNode = new ListNode();
  let curr = listNode;
  let carry = 0;

  while (l1 !== null || l2 !== null) {
      let sum = carry;
      if (l1 !== null) {
          sum += l1.val;
          l1 = l1.next;
      }
      if (l2 !== null) {
          sum += l2.val;
          l2 = l2.next;
      }
      curr.next = new ListNode(sum % 10);
      carry = Math.floor(sum / 10);
      curr = curr.next;
  }

  if (carry > 0) {
      curr.next = new ListNode(carry);
  }

  return listNode.next;
}
const l1 = new ListNode(2, new ListNode(4, new ListNode(3, null)))
const l2 = new ListNode(5, new ListNode(6, new ListNode(4, null)))

console.log(addTwoNumbers(l1, l2))