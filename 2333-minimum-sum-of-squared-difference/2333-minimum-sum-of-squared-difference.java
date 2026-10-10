class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int[] arr = new int[100001]; 
        long t = 0;
        for (int i = 0; i < nums1.length; i++) {
            int d = Math.abs(nums1[i] - nums2[i]);
            arr[d]++;
            t += d;
        }
        long k = (long) k1 + k2;
        if (t <= k) return 0;
        for (int i = 100000; i > 0 && k > 0; i--) {
            if (arr[i] > 0) {
                long red = Math.min((long) arr[i], k);
                arr[i] -= red;
                arr[i - 1] += red;
                k -= red;
            }
        }
        long r = 0;
        for (int i = 1; i <= 100000; i++) {
            if (arr[i] > 0) r += (long) i * i * arr[i];
        }
        return r;
    }
}