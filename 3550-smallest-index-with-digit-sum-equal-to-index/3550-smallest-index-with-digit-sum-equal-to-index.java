class Solution {
    public int smallestIndex(int[] nums) {
        int a=-1;
        for(int i=0; i<nums.length; i++){
            int s=0;
            while(nums[i]>0){
                int d=nums[i]%10;
                s+= d;
                nums[i]=nums[i]/10;
            }
            if(s==i){
                a=i;
                return a;
            }
        }
        return a;
    }
}