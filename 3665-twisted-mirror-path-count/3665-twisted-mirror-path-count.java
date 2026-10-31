class Solution {
    public int uniquePaths(int[][] grid) {
        final int m=1_000_000_007;
        int[] d=new int[grid[0].length];
        d[0]=1;
        for(int[] x:grid){
            int r=0;
            for(int i=0;i<x.length;i++){
                if(x[i]==1){
                    int t=r;
                    r=d[i];
                    d[i]=t;
                }else r=d[i]=(r+d[i])%m;
            }
        }
        return d[d.length-1];
    }
}