class Solution {
    public long findKthSmallest(int[] coins, int k) {
        long[] multiples = new long[(1 << coins.length) - 1];
        for (int mask = 1; mask < (1 << coins.length); mask++) {
            int bits = 0;
            long curLcm = 1L;
            for (int i = 0; i < coins.length; i++) {
                if ((mask & (1 << i)) != 0) {
                    bits++;
                    curLcm = lcm(curLcm, coins[i]);
                }
            }
            if (bits % 2 == 0) multiples[mask - 1] = -curLcm;
            else multiples[mask - 1] = curLcm;
        }
        return binarySearch(multiples, k);
    }
    private long binarySearch(long[] multiples, int k) {
        long low = 1, high = (long) k * 25;
        while (low < high) {
            long mid = low + (high - low) / 2, count = 0;
            for (long value : multiples) {
                if (value > 0) count += mid / value;
                else count -= mid / Math.abs((long) value);
            }
            if (count >= k) high = mid;
            else low = mid + 1;
        }
        return low;
    }
    long lcm(long a, long b){ 
        return a / gcd(a, b) * b;
    }
    long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}