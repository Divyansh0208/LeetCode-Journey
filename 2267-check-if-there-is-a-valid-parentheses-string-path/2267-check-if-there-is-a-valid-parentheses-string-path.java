class Solution {
    private int f(int i , int j , int ct , char[][] grid , int[][][] dp){
        if( i >= grid.length || j >= grid[0].length) return 0;
        ct += (grid[i][j] == '(' ? 1 : - 1);
        if(ct < 0) return 0;
        int r = (grid.length - 1 - i) + (grid[0].length - 1 - j);
        if (ct > r + 1) return 0;
        if(i == grid.length - 1 && j == grid[0].length - 1){
            if(ct == 0) return 1;
            else return 0;
        }
        if(dp[i][j][ct] != -1)return dp[i][j][ct];
        int a = f(i + 1, j , ct , grid, dp), b  = f(i , j + 1 , ct , grid , dp);
        return dp[i][j][ct] = (a == 1 ? a : b);    
    }
    public boolean hasValidPath(char[][] grid) {
        int[][][] dp = new int[grid.length][grid[0].length][grid.length + grid[0].length];
        if ((grid.length + grid[0].length) % 2 == 0) return false;
        for(int i = 0 ;i < grid.length ; ++i){
            for(int j  = 0 ; j < grid[0].length ; ++j){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return f(0,0,0,grid,dp) == 1;
    }
}