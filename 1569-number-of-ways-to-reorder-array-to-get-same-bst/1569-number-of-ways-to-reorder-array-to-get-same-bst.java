class Solution {
    int m = 1000000007;
    long[][] c = new long[1001][1001];
    public int numOfWays(int[] nums) {
        int n = nums.length;
        for (int i = 0; i <= n; i++) {
            c[i][0] = 1;
            c[i][i] = 1;
            for (int j = 1; j < i; j++) c[i][j] = (c[i - 1][j - 1] + c[i - 1][j]) % m;
        }
        return (int) ((ways(nums) - 1 + m) % m);
    }
    long ways(int[] nums) {
        if (nums.length <= 2) return 1;
        int root = nums[0];
        java.util.List<Integer> left = new java.util.ArrayList<>();
        java.util.List<Integer> right = new java.util.ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < root) left.add(nums[i]);
            else right.add(nums[i]);
        }
        int[] l = new int[left.size()];
        int[] r = new int[right.size()];
        for (int i = 0; i < left.size(); i++) l[i] = left.get(i);
        for (int i = 0; i < right.size(); i++) r[i] = right.get(i);
        long lw = ways(l), rw = ways(r), com = c[nums.length - 1][left.size()];
        return com * lw % m * rw % m;
    }
}