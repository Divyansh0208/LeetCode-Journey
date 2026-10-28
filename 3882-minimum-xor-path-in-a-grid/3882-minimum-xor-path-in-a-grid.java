class Solution {
    public int minCost(int[][] grid) {
        boolean[][][] a=new boolean[grid.length][grid[0].length][1024];
        a[grid.length-1][grid[0].length-1][grid[grid.length-1][grid[0].length-1]]=true;
        for(int i=grid.length-1;i>=0;i--){
            for(int j=grid[0].length-1;j>=0;j--){
                if(i==grid.length-1 && j==grid[0].length-1) continue;
                if (i+1<grid.length)
                    for (int x = 0; x < 1024; x++)
                        if (a[i+1][j][x]) a[i][j][x ^ grid[i][j]] = true;

                if (j+1 < grid[0].length)
                    for (int x = 0; x < 1024; x++)
                        if (a[i][j+1][x]) a[i][j][x ^ grid[i][j]] = true;
            }
        }
        for(int i=0;i<1024;i++){
            if(a[0][0][i]) return i;
        }
        return 0;
    }
}