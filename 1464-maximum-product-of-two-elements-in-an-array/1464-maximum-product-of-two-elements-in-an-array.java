class Solution {
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int a=nums.length-1;
        return (nums[a]-1)*(nums[a-1]-1);
    }
}