class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] a = new long[k], b = new long[k];
        for(int i:nums){
            int mod=i%k;
            long[] tmp=new long[k];
            for(int j=0;j<k;j++){
                int n=(j*mod)%k;
                tmp[n]+=b[j];
                a[n]+=b[j];
            }
            a[mod]++; tmp[mod]++; b=tmp;
        }
        return a;
    }
}