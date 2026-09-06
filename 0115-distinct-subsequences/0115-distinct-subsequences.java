class Solution {
    public int numDistinct(String s, String t) {
        int[] arr = new int[t.length() + 1];
        arr[0] = 1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = t.length(); j >= 1; j--) {
                if (s.charAt(i) == t.charAt(j - 1)) arr[j] += arr[j - 1];
            }
        }
        return arr[t.length()];
    }
}