class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;
        char[] st = new char[s.length()];
        int a = 0;
        for (char i : s.toCharArray()) {
            if (i == '(') st[a++] = ')';
            else if (i == '{') st[a++] = '}';
            else if (i == '[') st[a++] = ']';
            else {
                if (a == 0 || st[--a] != i) return false;
            }
        }
        return a == 0;
    }
}