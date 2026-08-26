class Solution {
    public void rotate(int[] nums, int k) {
        k=k%nums.length;
        rev(nums,0,nums.length-1);
        rev(nums,0,k-1);
        rev(nums,k,nums.length-1);
    }
    void rev(int[] nums, int a, int b) {
        while(b>a) {
            int t=nums[a];
            nums[a]=nums[b];
            nums[b]=t;
            a++;b--;
        }
    }
}