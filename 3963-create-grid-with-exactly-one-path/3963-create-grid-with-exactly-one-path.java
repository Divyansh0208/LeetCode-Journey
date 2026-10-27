class Solution {
    public String[] createGrid(int m, int n) {
        String[] g = new String[m];
        Arrays.fill(g, "#".repeat(n - 1) + ".");
        g[0] = ".".repeat(n);
        return g;
    }
}