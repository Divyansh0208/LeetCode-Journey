class Solution {
    public int minInsertions(String s) {
        int a = 0, b = 0;
        for (char i : s.toCharArray()) {
            if (i == '(') {
                b += 2;
                if (b % 2 == 1) {
                    a++;
                    b--;
                }
            } else {
                b--;
                if (b < 0) {
                    a++;
                    b = 1;
                }
            }
        }
        return a + b;
    }
}