class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] dr = arr.clone();
        Arrays.sort(dr);
        HashMap<Integer, Integer> r = new HashMap<>();
        int cr= 1;
        for (int num : dr) {
            if (!r.containsKey(num)) r.put(num, cr++);
        }
        for (int i = 0; i < arr.length; i++) arr[i] = r.get(arr[i]);
        return arr;
    }
}