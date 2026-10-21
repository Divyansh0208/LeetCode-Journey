class Solution {
    public int minOperations(String s) {
        boolean c = true;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(i - 1)) {
                c = false;
                break;
            }
        }
        if (c) return 0;
        if (s.length() == 2) return -1;
        char a = 'z', b = 'a';
        for (char i : s.toCharArray()) {
            a = (char) Math.min(a, i);
            b = (char) Math.max(b, i);
        }
        if (s.charAt(0) == a || s.charAt(s.length() - 1) == b) return 1;
        for (int i = 1; i < s.length() - 1; i++) {
            if (s.charAt(i) == a || s.charAt(i) == b) return 2;
        }
        return 3;
    }
}