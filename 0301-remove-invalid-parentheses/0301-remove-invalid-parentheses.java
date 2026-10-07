class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> an = new ArrayList<>();
        remove(s, an, 0, 0, new char[] { '(', ')' });
        return an;
    }
    public void remove(String s, List<String> an, int last_i, int last_j, char[] par) {
        for (int a = 0, i = last_i; i < s.length(); ++i) {
            if (s.charAt(i) == par[0]) a++;
            if (s.charAt(i) == par[1]) a--;
            if (a >= 0) continue;
            for (int j = last_j; j <= i; ++j) {
                if (s.charAt(j) == par[1] && (j == last_j || s.charAt(j - 1) != par[1])) remove(s.substring(0, j) + s.substring(j + 1), an, i, j, par);
            }
            return;
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if (par[0] == '(') remove(reversed, an, 0, 0, new char[] { ')', '(' });
        else an.add(reversed);
    }
}