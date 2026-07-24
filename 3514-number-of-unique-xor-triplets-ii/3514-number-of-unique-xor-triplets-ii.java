class Solution {
    public int uniqueXorTriplets(int[] nums) {
        if (nums.length == 1) return 1;
        HashSet<Integer> pair = new HashSet<>();
        for (int i=0; i<nums.length; i++) {
            for (int j=i+1; j<nums.length; j++) pair.add(nums[i]^nums[j]);
        }
        BitSet seen = new BitSet();
        for (int i:pair) {
            for (int j:nums) seen.set(i^j);
        }
        return seen.cardinality();
    }
}