class Solution {
    public int minMoves(int[] nums) {
        int a=0,b=0;
        for(int i:nums){
            if(i>a) a=i;
        }
        for(int i:nums) b+=a-i;
        return b;
    }
}