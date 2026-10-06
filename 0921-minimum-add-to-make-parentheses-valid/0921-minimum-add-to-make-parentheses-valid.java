class Solution {
    public int minAddToMakeValid(String s) {
        while (true) {
            int a = s.indexOf("()");
            if (a == -1) return s.length();
            s = s.substring(0, a) + s.substring(a + 2);
        }
    }
}