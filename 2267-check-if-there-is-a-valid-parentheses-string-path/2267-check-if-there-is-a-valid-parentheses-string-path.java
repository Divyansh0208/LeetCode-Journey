class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        if ((m + n - 1) % 2 != 0) return false;
        if (grid[0][0] == ')' || grid[m-1][n-1] == '(') return false;
        Boolean[][][] memo = new Boolean[m][n][m + n];
        return dfs(grid, 0, 0, 0, memo);
    }
    private boolean dfs(char[][] grid, int i, int j, int balance, Boolean[][][] memo) {
        int m = grid.length, n = grid[0].length;
        balance += grid[i][j] == '(' ? 1 : -1;
        if (balance < 0) return false;
        if (i == m - 1 && j == n - 1) return balance == 0;
        if (memo[i][j][balance] != null) return memo[i][j][balance];
        boolean r = false;
        if (i + 1 < m) r |= dfs(grid, i + 1, j, balance, memo);
        if (!r && j + 1 < n) r |= dfs(grid, i, j + 1, balance, memo);
        memo[i][j][balance] = r;
        return r;
    }
}