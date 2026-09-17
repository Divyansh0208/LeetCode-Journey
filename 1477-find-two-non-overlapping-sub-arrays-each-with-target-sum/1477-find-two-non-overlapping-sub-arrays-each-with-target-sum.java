class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int[] b = new int[arr.length + 1];
        for (int i = 0; i <= arr.length; i++) b[i] = arr.length + 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        int prefixSum = 0, res = arr.length + 1;
        for (int i = 1; i <= arr.length; i++) {
            prefixSum += arr[i - 1];
            b[i] = b[i - 1];
            if (map.containsKey(prefixSum - target)) {
                int left = map.get(prefixSum - target);
                int length = i - left;
                if (b[left] != arr.length + 1) res = Math.min(res, b[left] + length);
                b[i] = Math.min(b[i], length);
            }
            map.put(prefixSum, i);
        }
        return res == arr.length + 1 ? -1 : res;
    }
}