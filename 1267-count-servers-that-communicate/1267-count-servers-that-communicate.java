class Solution {
    public int countServers(int[][] grid) {
        int[] cr=new int[grid.length];
        int[] cc=new int[grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    cr[i]++;cc[j]++;
                }
            }
        }
        int a=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1 && (cr[i]>1 || cc[j]>1)) a++;
            }
        }
        return a;
    }
}