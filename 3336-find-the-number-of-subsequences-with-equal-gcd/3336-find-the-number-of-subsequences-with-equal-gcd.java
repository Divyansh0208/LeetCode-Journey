class Solution {
    static final int MOD = 1_000_000_007;
    Integer[][][] memo;
    public int subsequencePairCount(int[] nums) {
        memo = new Integer[nums.length][201][201];
        return dfs(nums, 0, 0, 0);
    }
    int dfs(int[] nums, int idx, int g1, int g2) {
        if (idx == nums.length) return (g1 != 0 && g1 == g2) ? 1 : 0;
        if (memo[idx][g1][g2] != null) return memo[idx][g1][g2];
        long ans = 0;
        ans += dfs(nums, idx + 1, g1, g2);
        int ng1 = (g1 == 0) ? nums[idx] : swap(g1, nums[idx]);
        ans += dfs(nums, idx + 1, ng1, g2);
        int ng2 = (g2 == 0) ? nums[idx] : swap(g2, nums[idx]);
        ans += dfs(nums, idx + 1, g1, ng2);
        return memo[idx][g1][g2] = (int)(ans % MOD);
    }

    int swap(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}