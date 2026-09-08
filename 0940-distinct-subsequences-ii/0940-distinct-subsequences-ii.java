class Solution {
    public int distinctSubseqII(String s) {
        long MOD = 1000000007L;
        long[] end = new long[26];
        long total = 0;
        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            long add = (total + 1) % MOD;
            total = (total + add - end[idx] + MOD) % MOD;
            end[idx] = add;
        }
        return (int) total;
    }
}