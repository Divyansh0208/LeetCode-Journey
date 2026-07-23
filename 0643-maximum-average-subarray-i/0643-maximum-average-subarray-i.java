class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double a=0;
        for (int i=0; i<k; i++) a+=nums[i];
        double b=a;
        for (int i=k; i<nums.length; i++) {
            a=a-nums[i-k]+nums[i];
            b=Math.max(b, a);
        }
        return b/k;
    }
}