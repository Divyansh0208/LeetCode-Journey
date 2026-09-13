class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        List<int[]> ones = new ArrayList<>();
        for (int r = 0; r < img1.length; r++) {
            for (int c = 0; c < img1.length; c++) {
                if (img1[r][c] == 1) ones.add(new int[]{r, c});
            }
        }
        int maxOverlap = 0;
        for (int dr = -(img1.length - 1); dr <= img1.length - 1; dr++) {
            for (int dc = -(img1.length - 1); dc <= img1.length - 1; dc++) {
                int overlap = 0;
                for (int[] cell : ones) {
                    int r = cell[0], c = cell[1];
                    int newRow = r + dr, newCol = c + dc;
                    if (newRow < 0 || newRow >= img1.length ||
                        newCol < 0 || newCol >= img1.length) {
                        continue;
                    }
                    if (img2[newRow][newCol] == 1) overlap++;
                }
                maxOverlap = Math.max(maxOverlap, overlap);
            }
        }
        return maxOverlap;
    }
}