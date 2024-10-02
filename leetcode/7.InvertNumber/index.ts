function reverse(x: number): number {

    let isNegative = x < 0
    let numberStr = isNegative ? (x*-1).toString() : x.toString()
    let revertStr = ''
    let i = numberStr.length - 1
    while (i >= 0) {
        revertStr += numberStr[i--]
    }
    let res = isNegative ? -revertStr : +revertStr
    if (res > Math.pow(2, 31) - 1 || res < -Math.pow(2, 31)) return 0

    return res
};
