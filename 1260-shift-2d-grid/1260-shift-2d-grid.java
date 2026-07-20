class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int len=grid.length*grid[0].length, idx=(len-k%len)%len;
        for (int i=0; i<grid.length; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j=0; j<grid[0].length; j++) {
                row.add(grid[idx/grid[0].length][idx%grid[0].length]);
                idx=(idx+1)%len;
            }
            res.add(row);
        }
        return res;
    }
}