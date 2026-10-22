class Solution {
    public int minOperations(int[] nums) {
        if(nums.length==1) return 0;
        int a=-1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]+1){
                if(a!=-1){
                    a=nums.length+1; break;
                }
                a=i;
            }
        }
        if(a==-1) return 0;
        if(a<nums.length) return Math.min(a,2+(nums.length-a));
        int b=-1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]-1){
                if(b!=-1){
                    b=nums.length+1; break;
                }
                b=i;
            }
        }
        if(b==-1) return 1;
        if(b<nums.length) return Math.min(b,nums.length-b)+1;
        return -1;
    }
}