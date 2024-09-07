var ListNode = /** @class */ (function () {
    function ListNode(val, next) {
        this.val = val === undefined ? 0 : val;
        this.next = next === undefined ? null : next;
    }
    return ListNode;
}());
function addTwoNumbers(l1, l2) {
    var listNode = new ListNode();
    var curr = listNode;
    var carry = 0;
    while (l1 !== null || l2 !== null) {
        var sum = carry;
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
var l1 = new ListNode(2, new ListNode(4, new ListNode(3, null)));
var l2 = new ListNode(5, new ListNode(6, new ListNode(4, null)));
console.log(addTwoNumbers(l1, l2));
