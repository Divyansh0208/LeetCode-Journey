class Solution {
    public boolean checkValidString(String s) {
        int open = 0;
        for (char i : s.toCharArray()) {
            if (i == '(' || i == '*') open++;
            else open--;
            if (open < 0) return false;
        }
        int c = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')' || s.charAt(i) == '*') c++;
            else c--;
            if (c < 0) return false;
        }
        return true;
    }
}