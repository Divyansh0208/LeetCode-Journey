class Solution {
    public int longestValidParentheses(String s) {
        int o = 0, c = 0, ans = 0;
        for (char i : s.toCharArray()) {
            if (i == '(') o++;
            else c++;
            if (o == c) ans = Math.max(ans, 2 * c);
            if (c > o) {
                o = 0;
                c = 0;
            }
        }
        o = 0; c = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') o++;
            else c++;
            if (o == c) ans = Math.max(ans, 2 * o);
            if (o > c) {
                o = 0;
                c = 0;
            }
        }
        return ans;
    }
}