class Solution {
    private Integer[][] arr; 
    private int netScore(int[] nums, int st, int en) {
        if(st > en) return 0;
        if(arr[st][en] != null) return arr[st][en]; 
        int l=nums[st]-netScore(nums, st+1, en), r=nums[en] -netScore(nums, st, en -1); 
        return arr[st][en]=Math.max(l, r); 
    }
    public boolean predictTheWinner(int[] nums) {
        arr=new Integer[nums.length][nums.length];
        return netScore(nums, 0, nums.length-1)>=0; 
    }
}