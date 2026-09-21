class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] a = new long[k], cnt = new long[k];
        for(int x: nums){
            int mod = x%k;
            long[] tmp = new long[k];
            for(int j=0;j<k;j++){
                int newMod = (j*mod)%k;
                tmp[newMod] += cnt[j];
                a[newMod] += cnt[j];
            }
            a[mod]++; tmp[mod]++; cnt = tmp;
        }
        return a;
    }
}