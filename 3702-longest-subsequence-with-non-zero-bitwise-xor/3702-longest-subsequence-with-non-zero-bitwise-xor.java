class Solution {
    public int longestSubsequence(int[] nums) {
        int x = 0;
        boolean z = false;
        for (int i : nums) {
            x ^= i;
            if (i != 0) z = true;
        }
        if (!z) return 0;
        if (x != 0) return nums.length;
        return nums.length - 1;
    }
}