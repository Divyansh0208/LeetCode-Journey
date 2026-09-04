class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length; 
        int p[] = new int[nums.length];
        int s[] = new int[nums.length];
        p[0] = nums[0]; 
        s[nums.length - 1] = nums[nums.length - 1]; 
        int mx = 0; 
        for(int i = 1; i < nums.length; i++) {
            p[i] = Math.max(p[i-1], nums[i]); 
            s[nums.length - i - 1] = Math.min(s[nums.length - i], nums[nums.length - i - 1]); 
        }
        for(int i = 0; i < nums.length; i++) {
            if(p[i] - s[i] <= k) return i; 
        }
        return -1 ;
    }
}