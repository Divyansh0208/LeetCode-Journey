class Solution {
    public String mergeAlternately(String s, String t) {
        StringBuilder r = new StringBuilder();
        int i = 0;
        while (i < s.length() || i < t.length()) {
            if(i<s.length()) r.append(s.charAt(i));
            if(i<t.length()) r.append(t.charAt(i));
            i++;
        }
        return r.toString();
    }
}