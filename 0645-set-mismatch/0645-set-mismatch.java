class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] ans=new int[2];
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]==nums[i-1]) ans[0]=nums[i];
            if (nums[i]-nums[i-1]>1) ans[1]=nums[i-1]+1;
        }
        if (nums[0]!=1) ans[1]=1;
        if (nums[nums.length-1]!=nums.length) ans[1]=nums.length;
        return ans;
    }
}