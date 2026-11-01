class Solution {
    public int minMoves(int[] nums) {
        int m=Integer.MAX_VALUE;
        for(int i:nums) if(i<m) m=i;
        long a=0;
        for(int i:nums) a+=i-m;
        return (int) a;
    }
}