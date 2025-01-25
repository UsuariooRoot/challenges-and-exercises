class ListNode {
    val: number
    next: ListNode | null
    constructor(val?: number, next?: ListNode | null) {
        this.val = (val === undefined ? 0 : val)
        this.next = (next === undefined ? null : next)
    }
}

function mergeKLists(lists: Array<ListNode | null>): ListNode | null {
    const res = new ListNode(-(10**4));
    let temp = res;

    while (true) {
        let lowestValueNode = Number.MAX_VALUE;
        let idxLowestValueNode = -1;

        for (let i = 0; i < lists.length; i++) {
            if (lists[i]) {
                if ((lists[i] as ListNode).val === temp.val) {
                    idxLowestValueNode = i;
                    break;
                }
                if ((lists[i] as ListNode).val < lowestValueNode) {
                    idxLowestValueNode = i;
                    lowestValueNode = (lists[i] as ListNode).val;
                }
            }
        }
        if (idxLowestValueNode < 0) break;

        temp.next = lists[idxLowestValueNode] as ListNode;
        temp = temp.next;
        lists[idxLowestValueNode] = (lists[idxLowestValueNode] as ListNode).next;
    }

    return res.next;
};
