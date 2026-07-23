class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length==0) return 0;
        int a=1, b=1;
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i]<nums[i+1]) b++;
            else{
                a=Math.max(a, b);
                b=1;
            }
        }
        a=Math.max(a, b);
        return a;
    }
}