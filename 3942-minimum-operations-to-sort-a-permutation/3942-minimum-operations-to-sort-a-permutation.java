class Solution { 
    public int minOperations(int[] nums) { 
        int shift = 0; 
        while (nums[shift] != 0) shift++; 
        boolean b = true, c = true; 
        for (int k = 0; k < nums.length && (b || c); k++) { 
            int r = nums[(shift + k) % nums.length];
            b &= r == k;
            c &= r == (nums.length - k) % nums.length;
        }
        if (b) return Math.min(shift, nums.length - shift + 2);
        if (c) return Math.min(shift + 2, nums.length - shift);
        return -1; 
    } 
}