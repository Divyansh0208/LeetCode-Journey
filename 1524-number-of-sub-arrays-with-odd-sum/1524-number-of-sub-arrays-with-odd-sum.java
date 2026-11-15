class Solution {
    public int numOfSubarrays(int[] arr) {
        final int MOD=1000000007;
        int a=0,b=1,c=0,d=0;
        for(int i:arr){
            c+=i;
            if(c%2==0){
                d=(d+a)%MOD;
                b++;
            }else{
                d=(d+b)%MOD;
                a++;
            }
        }
        return d;
    }
}