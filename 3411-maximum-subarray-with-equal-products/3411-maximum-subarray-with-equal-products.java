class Solution {
    public int maxLength(int[] nums) {
        int a=0;
        for(int i=0;i<nums.length;i++){
            long b=nums[i],c=nums[i];
            double d=1.0/nums[i];
            for(int j=i;j<nums.length;j++){
                if(j>i){
                    b=gcd(b,nums[j]);
                    c=c/gcd(c,nums[j])*nums[j];
                    d/=nums[j];
                }
                if(b*(double)c*d>0.99999999) a=Math.max(a,j-i+1);
            }
        }
        return a;
    }
    private long gcd(long a,long b){
        return b==0?a:gcd(b,a%b);
    }
}