function longestPalindrome(s: string): string {
    let result = "";
    if (s.length <= 1) return s;
    
    const isPalindrome= (str: string) => {
        for (let i = 0; i < Math.floor(str.length / 2); i++) {
            if (str[i] !== str[str.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    for (let i = 0; i < s.length; i++) {
        for (let j = i; j < s.length; j++) {
            const substr = s.slice(i, j + 1);
            if (isPalindrome(substr) && substr.length > result.length) {
                result = substr;
            }
        }
    }

    return result;
}

function longestPalindrome2(s: string): string {
    if (s.length <= 1) return s;

    let result = '';

    const expandAroundCenter = (left: number, right: number): string => {
        while (left >= 0 && right < s.length && s[left] === s[right]) {
            left--;
            right++;
        }
        return s.slice(left + 1, right);
    };

    for (let i = 0; i < s.length; i++) {
        const oddPalindrome = expandAroundCenter(i, i);
        const evenPalindrome = expandAroundCenter(i, i + 1);

        const longerPalindrome = oddPalindrome.length > evenPalindrome.length ? oddPalindrome : evenPalindrome;

        if (longerPalindrome.length > result.length) {
            result = longerPalindrome;
        }
    }

    return result;
}