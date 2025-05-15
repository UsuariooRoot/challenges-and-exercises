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

function countPrimes2(n: number): number {
    let res = 0;
    if (n > 2) res++;
    if (n > 3) res++;

    function isPrime(n: number) {
        if (n % 3 === 0)
            return false;

        for (let i = 5; i <= Math.sqrt(n); i += 6)
            if (n % i === 0 || n % (i + 2) === 0)
                return false;
    
        return true;
    }

    for (let num = 5; num < n; num += 2) {
        if (isPrime(num)) {
            res++;
        }
    }

    return res;
};