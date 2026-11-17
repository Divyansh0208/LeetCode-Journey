class Solution {
    private static final int INF = 10000;
    private int[][] memo;
    private int[][] cost;
    private int solve(int idx, int k, int n) {
        if (idx == n || k == 0) return (idx == n && k == 0) ? 0 : INF;
        if (memo[idx][k] != -1) return memo[idx][k];
        int res = INF;
        for (int l = 2; idx + l <= n; l++) res = Math.min(res, cost[idx][l] + solve(idx + l, k - 1, n));
        return memo[idx][k] = res;
    }

    public int minimumChanges(String s, int k) {
        memo = new int[s.length() + 1][k + 1];
        for (int[] row : memo) Arrays.fill(row, -1);
        cost = new int[s.length() + 1][s.length() + 1];
        for (int[] row : cost) Arrays.fill(row, Integer.MAX_VALUE / 2);
        for (int d = 1; d <= s.length() / 2; d++) {
            int[][] tmp = new int[s.length() + 1][s.length() + 1];
            for (int len = 2 * d; len <= s.length(); len += d) {
                for (int idx = 0; idx + len <= s.length(); idx++) {
                    int ops = 0;
                    for (int o = 0; o < d; o++) {
                        if (s.charAt(idx + o) != s.charAt(idx + len - d + o)) ops++;
                    }
                    tmp[idx][len] = ops + tmp[idx + d][len - 2 * d];
                    cost[idx][len] = Math.min(cost[idx][len], tmp[idx][len]);
                }
            }
        }
        return solve(0, k, s.length());
    }
}