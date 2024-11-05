class Solution {
    public boolean isPalindrome(int x) {
        int reversed = 0;
        int num = x;

        while (num != 0) {
            reversed = reversed * 10 + num % 10;
            num /= 10;
        }
        
        return (reversed == x);
    }
}