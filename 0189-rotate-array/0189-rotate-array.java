class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        Rev(nums, 0, nums.length - 1);
        Rev(nums, 0, k - 1);
        Rev(nums, k, nums.length - 1);
    }
    void Rev(int[] nums, int a, int b) {
        while (b > a) {
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
            a++;
            b--;
        }
    }
}