class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int m=nums[nums.length/2];
        long a=0;
        for(int i=0;i<nums.length;i++) a+=Math.abs((long) nums[i]-m);
        return (int) a;
    }
}