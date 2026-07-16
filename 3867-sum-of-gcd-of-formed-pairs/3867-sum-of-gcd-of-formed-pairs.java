class Solution {
    private int gcd(int a, int b) {
        if (b==0) return a;
        return gcd(b, a%b);
    }
    public long gcdSum(int[] nums) {
        int[] arr=new int[nums.length];
        int a=0;
        for (int i=0; i<nums.length; i++) {
            a=Math.max(a, nums[i]);
            arr[i]=gcd(nums[i], a);
        }
        Arrays.sort(arr);
        long r=0;
        for (int i=0; i<nums.length/2; i++) r+=gcd(arr[i], arr[nums.length-1-i]);
        return r;
    }
}