class Solution {
    public int sumOfSquares(int[] nums) {
        int a=0;
        for(int i=0;i<nums.length;i++){
            if(nums.length%(i+1)==0) a+=nums[i]*nums[i];
        }
        return a;
    }
}