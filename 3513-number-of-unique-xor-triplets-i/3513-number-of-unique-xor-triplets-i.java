class Solution {
    public int uniqueXorTriplets(int[] nums) {
        if (nums.length<=2) return nums.length;
        int a=0, i=nums.length;
        while (i>0) {
            a++;
            i>>=1;
        }
        return 1<<a;
    }
}