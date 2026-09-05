class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int[] mini = new int[nums.length];
        int mint = Integer.MAX_VALUE;
        for(int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < mint) mint = nums[i];
            mini[i] = mint;
        }
        int maxt = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > maxt) maxt = nums[i];
            if(maxt - mini[i] <= k) return i;
        }

        return -1;
    }
}