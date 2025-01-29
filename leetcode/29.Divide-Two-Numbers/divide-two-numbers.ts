/**
 * Created: 2025-01-28
 * Author: UoRoot
 * Problem: https://leetcode.com/problems/divide-two-integers
 */
function divide(dividend: number, divisor: number): number {
    let dividendAbs = Math.abs(dividend), divisorAbs = Math.abs(divisor);
    if (divisorAbs > dividendAbs) return 0;

    const bitsDividend = dividendAbs.toString(2);
    let bitsDivisorLength = divisorAbs.toString(2).length;

    let D = bitsDividend.substring(0, bitsDivisorLength);
    let quotient = "";

    while (bitsDivisorLength <= bitsDividend.length) {
        let D10 = globalThis.parseInt(D, 2);
        if (D10 >= divisorAbs) {
            D = (D10 - divisorAbs).toString(2);
            D += bitsDividend.charAt(bitsDivisorLength);
            quotient += "1";
        } else {
            D += bitsDividend.charAt(bitsDivisorLength);
            quotient += "0";
        }
        bitsDivisorLength++;
    }

    const sign = (divisor<0 && dividend<0) || (divisor>0 && dividend>0);
    const res = globalThis.parseInt(quotient, 2);

    if (sign && res > 2147483647) {
        return 2147483647;
    } else if (!sign && res > 2147483648) {
        return 2147483648;
    }

    return sign ? res : -res;
};
