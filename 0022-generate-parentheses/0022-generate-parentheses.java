class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> r = new ArrayList<>();
        b(r, "", 0, 0, n);
        return r;
    }
    private void b(List<String> r, String cu, int o, int c, int n) {
        if (o == n && c == n) {
            r.add(cu);
            return;
        }
        if (o < n) b(r, cu + "(", o + 1, c, n);
        if (c < o) b(r, cu + ")", o, c + 1, n);
    }
}