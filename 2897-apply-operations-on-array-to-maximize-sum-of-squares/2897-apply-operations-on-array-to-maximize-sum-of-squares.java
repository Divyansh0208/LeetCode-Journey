class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int a=1000000007;
        int[] arr=new int[31];
        for(int i:nums){
            for(int j=0;j<31;j++) arr[j]+=(i>>j)&1;
        }
        long r=0;
        while(k-->0){
            long b=0;
            for(int i=0;i<31;i++){
                if(arr[i]>0){
                    b|=1L<<i;
                    arr[i]--;
                }
            }
            r=(r+b*b)%a;
        }
        return (int) r;
    }
}