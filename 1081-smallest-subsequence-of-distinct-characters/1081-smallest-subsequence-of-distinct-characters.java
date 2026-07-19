class Solution {
    public String smallestSubsequence(String text) {
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[128];
        boolean[] used = new boolean[128];
        for (char c : text.toCharArray()) arr[c]++;
        for (char c : text.toCharArray()) {
            arr[c]--;
            if (used[c]) continue;
            while (sb.length() > 0 && last(sb) > c && arr[last(sb)] > 0) {
                used[last(sb)] = false;
                sb.setLength(sb.length() - 1);
            }
            sb.append(c);
            used[c] = true;
        }
        return sb.toString();
    }
    private char last(StringBuilder sb) {
        return sb.charAt(sb.length() - 1);
    }
}