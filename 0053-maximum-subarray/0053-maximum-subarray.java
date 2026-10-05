class Solution {
    public int maxSubArray(int[] nums) {
        int a=nums[0], b=0;
        for(int i:nums){
            b+=i;
            a=Math.max(a,b);
            if(b<0) b=0;
        }
        return a;
    }
}