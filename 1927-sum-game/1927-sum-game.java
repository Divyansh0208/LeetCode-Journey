class Solution {
    public boolean sumGame(String num) {
        int a = 0, b = 0;
        for (int i = 0; i < num.length(); i++) {
            boolean c = i < num.length() / 2;

            if (num.charAt(i) == '?') b += c ? 1 : -1;
            else {
                int d = num.charAt(i) - '0';
                a += c ? d : -d;
            }
        }
        return 2*a!=-9*b;
    }
}