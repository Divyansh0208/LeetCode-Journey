class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int mx = 0;
        int[] d = new int[nums1.length];
        long t = 0;
        for (int i = 0; i < nums1.length; ++i) {
            d[i] = Math.abs(nums1[i] - nums2[i]);
            t += d[i];
            mx = Math.max(mx, d[i]);
        }
        long k = (long)k1 + k2;
        if (t <= k) return 0;
        int l = 0, r = mx;
        while (l < r) {
            int m = l + (r - l) / 2;
            long n = 0;
            for (int v : d) n += Math.max(0, v - m);
            if (n <= k) r = m;
            else l = m + 1;
        }
        for (int i = 0; i < nums1.length; ++i) {
            k -= Math.max(0, d[i] - l);
            d[i] = Math.min(d[i], l);
        }
        for (int i = 0; i < nums1.length && k > 0; ++i) {
            if (d[i] == l) {
                --d[i];
                --k;
            }
        }
        long a = 0;
        for (int v : d) a += (long)v * v;
        return a;
    }
}