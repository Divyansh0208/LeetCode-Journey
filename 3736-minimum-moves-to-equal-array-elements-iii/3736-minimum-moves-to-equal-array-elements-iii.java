class Solution {
    public int minMoves(int[] nums) {
        int a=Integer.MIN_VALUE, b=0;
        for(int i:nums){
            a=Math.max(a, i);
            b+=i;
        }
        return nums.length*a-b;
    }
}