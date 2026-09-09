class Solution {
    public long countCommas(long n) {
        long a = 0;
        long d = 1;
        long s = 1;
        long p = 10;
        while (s <= n) {
            long e = Math.min(n, p - 1);
            long c = e - s + 1;
            if (d >= 4) {
                long co = (d - 1) / 3;
                a += c * co;
            }
            d++;
            s = p;
            p *= 10;
        }
        return a;
    }
}
