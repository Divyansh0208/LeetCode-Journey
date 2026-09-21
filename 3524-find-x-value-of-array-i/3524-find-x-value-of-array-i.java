class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] a=new long[k];
        long[] b=new long[k];
        for (int i:nums) {
            int c=((i%k)+k)%k;
            long[] d = new long[k];
            d[c]++; a[c]++;
            for (int j = 0; j < k; j++) {
                int n=(j*c)%k;
                d[n]+=b[j];
                a[n]+=b[j];
            }
            b=d;
        }
        return a;
    }
}