class Solution {
    static {
        for(int i=0;i<100;i++){
            findMaxAverage(new int[1],1);
        }
    }
    public static double findMaxAverage(int[] nums, int k) {
        int a = 0, b=0;
        for (int i=0; i<k; i++) b+=nums[i];
        a=b;
        for (int i=1; i<=nums.length-k; i++) {
            b+=nums[i+k-1]-nums[i-1];
            a=Math.max(a,b);
        }
        return (double)a/k;
    }
}