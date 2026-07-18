class Solution {
    public int findGCD(int[] nums) {
        int a=nums[0], b=nums[0];
        for (int i:nums) {
            a=Math.min(a, i);
            b=Math.max(b, i);
        }
        return gcd(a, b);
    }
    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}