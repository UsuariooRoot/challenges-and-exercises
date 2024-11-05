class Solution {

    public static int maxArea(int[] height) {
        if (height.length <= 1) return 0;
        
        int hLenght = height.length - 1;
        int maxA = 0, left = 0;

        while (hLenght - left > 0) {
            maxA = Math.max(maxA, Math.min(height[left], height[hLenght]) * (hLenght - left));
            if (height[left] < height[hLenght]) {
                left++;
             } else {
                hLenght--;
             }
        }

        return maxA;
    }

    public static void main(String[] args) {
        maxArea(new int[]{5, 4, 3, 2, 7, 3, 4}); // 24
        maxArea(new int[]{1, 2, 3, 2, 8, 4, 8, 1, 2}); // 16
        maxArea(new int[]{1, 1, 3}); // 2
        maxArea(new int[]{1, 2}); // 1
        maxArea(new int[]{8,7,2,1}); // 7
    }
    
}