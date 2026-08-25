class Solution {
    public int missingMultiple(int[] nums, int k) {
        int[] arr=new int[101];
        for(int i=0;i<nums.length;i++) arr[nums[i]-1]=nums[i];
        int a=0;
        for(a=k-1;a<101;a+=k){
            if(arr[a]==0) {
                return a+1;
            }
        }
        return a+1;
    }
}