class ListNode {
    val: number
    next: ListNode | null
    constructor(val?: number, next?: ListNode | null) {
        this.val = (val === undefined ? 0 : val)
        this.next = (next === undefined ? null : next)
    }
}

function mergeKLists(lists: Array<ListNode | null>): ListNode | null {
    const res = new ListNode(-(10 ** 4));
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

function mergeKLists2(lists: Array<ListNode | null>): ListNode | null {
    if (lists.length < 1){
        return null;
    }

    let list1 = lists[0];

    for (let i = 1; i < lists.length; i++) {
        list1 = mergeTwoLists(list1, lists[i])
    }

    return list1;
};

function mergeTwoLists(list1: ListNode | null, list2: ListNode | null): ListNode | null {
    const res = new ListNode(0);
    let temp = res;

    while (list1 && list2) {
        if (list1.val < list2.val) {
            temp.next = list1;
            list1 = list1.next;
        } else {
            temp.next = list2;
            list2 = list2.next;
        }
        temp = temp.next;
    }

    temp.next = list1 == null ? list2 : list1;

    return res.next;
}