function countPrimes(n: number): number {
    let res = 0;
    if (n > 2) res++;
    const primeNumbers = [2]

    const isPrime = (n: number) => {
        for (let i = 0; i < primeNumbers.length; i++) {
            const div = primeNumbers[i];
            if (div * 2 > n) break;
            if (n % div === 0) return false;
        }
        return true;
    }

    for (let num = 3; num < n; num += 2) {
        if (isPrime(num)) {
            primeNumbers.push(num)
            res++;
        }
    }

    return res;
};
