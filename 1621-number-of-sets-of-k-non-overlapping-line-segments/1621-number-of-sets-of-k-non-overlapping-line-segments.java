class Solution {
    public int numberOfSets(int n, int k) {
        final long MOD = 1_000_000_007L;
        long[] arr = new long[n];
        long[] brr = new long[n + 1];
        for (int j = 0; j < n; j++) {
            arr[j] = 1;
            brr[j + 1] = (brr[j] + arr[j]) % MOD;
        }
        for (int i = 0; i < k; i++) {
            arr[0] = 0;
            for (int j = 1; j < n; j++) arr[j] = (arr[j - 1] + brr[j]) % MOD;
            brr[0] = 0;
            for (int j = 0; j < n; j++) brr[j + 1] = (brr[j] + arr[j]) % MOD;
        }
        return (int) arr[n - 1];
    }
}