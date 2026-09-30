class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int[] arr = new int[seq.length()];
        int a = 0;
        for (int i = 0; i < seq.length(); i++) {
            if (seq.charAt(i) == '(') {
                a++;
                arr[i] = a % 2;
            } else {
                arr[i] = a % 2;
                a--;
            }
        }
        return arr;
    }
}