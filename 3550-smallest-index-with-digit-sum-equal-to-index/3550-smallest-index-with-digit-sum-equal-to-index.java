class Solution {
    public int smallestIndex(int[] nums) {
        for (int i=0; i<nums.length; i++){
            int s=0;
            while (nums[i]>0) {
                int d=nums[i]%10;
                s+=d;
                nums[i]=nums[i]/10;
            }
            if (s==i) return i;
        }
        return -1;
    }
}