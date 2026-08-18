class Solution {
    public int largestInteger(int[] nums, int k) {
        if (k == nums.length) {
            int maxValue = nums[0];
            for (int i : nums) maxValue = Math.max(maxValue, i);
            return maxValue;
        }
        List<Integer> arr = new ArrayList<>();
        if (k == 1) {
            for (int i : nums) {
                int count = 0;
                for (int j : nums) {
                    if (i == j) count++;
                }
                if (count == 1) arr.add(i);
            }
        }else{
            int[] candidates = {nums[0], nums[nums.length - 1]};
            for (int i : candidates){
                int count = 0;
                for (int j : nums){
                    if (i == j) count++;
                }
                if (count == 1) arr.add(i);
            }
        }
        if (arr.isEmpty()) return -1;
        return Collections.max(arr);
    }
}