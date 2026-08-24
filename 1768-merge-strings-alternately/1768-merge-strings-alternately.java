class Solution {
    public String mergeAlternately(String s, String t) {
        StringBuilder r = new StringBuilder();
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            r.append(s.charAt(i++));
            r.append(t.charAt(j++));
        }
        r.append(s.substring(i));
        r.append(t.substring(j));
        return r.toString();
    }
}