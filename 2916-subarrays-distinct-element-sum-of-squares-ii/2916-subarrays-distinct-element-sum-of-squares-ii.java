class Solution {
    public int sumCounts(int[] nums) {
        final long m=1_000_000_007;
        long[] c=new long[nums.length+1],t=new long[nums.length+1];
        Map<Integer,Integer> l=new HashMap<>();
        long a=0;
        for(int i=0;i<nums.length;i++){
            int p=l.getOrDefault(nums[i],-1);
            long g=0,h=0;
            for(int j=nums.length-p-1;j>0;j-=j &-j){
                g+=c[j]; h+=t[j];
            }
            long gain=(long)(i-p)*(i-p)-2*(h-p*g);
            a=(a+(nums.length-i)*gain)%m;
            for(int j=nums.length-p;j<=nums.length;j+=j &-j){
                c[j]++; t[j]+=p;
            }
            l.put(nums[i],i);
        }
        return (int) a;
    }
}