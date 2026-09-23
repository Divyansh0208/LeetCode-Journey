class Solution {
    public int minOperations(int[] nums, int x) {
        int a=0;
        for(int i:nums) a+=i;
        int b=a-x;
        if(b<0) return -1;
        if(b==0) return nums.length;
        int l=0,s=0,m=-1;
        for(int i=0;i<nums.length;i++){
            s+=nums[i];
            while(s>b){
                s-=nums[l];
                l++;
            }
            if(s==b){
                m=Math.max(m,i-l+1);
            }
        }
        if(m==-1) return -1;
        return nums.length-m;
    }
}